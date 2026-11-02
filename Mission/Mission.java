package Mission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Enums.*;
import ColonyAgent.ColonyAgent;
import MarsColony.*;
import CrewMember.*;
import RoboticUnit.*;

public abstract class Mission {
    protected final String id;
    protected final String name;
    protected final String targetLocation;
    protected final int totalDuration;
    protected int elapsedTime;
    protected MissionStatus status;
    protected String failureReason;
    protected final List<ColonyAgent> assignedAgents;
    protected final Map<ResourceType, Integer> requiredResources;
    private String uniquekey = UUID.randomUUID().toString();

    public Mission(String id, String name, String targetLocation, int totalDuration) {
        if (totalDuration <= 0) {
            throw new IllegalArgumentException("Mission duration must be at least 1 time unit.");
        }
        this.id = id + uniquekey;
        this.name = name;
        this.targetLocation = targetLocation;
        this.totalDuration = totalDuration;
        this.elapsedTime = 0;
        this.status = null;
        this.failureReason = null;
        this.assignedAgents = new ArrayList<>();
        this.requiredResources = new EnumMap<>(ResourceType.class);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public MissionStatus getStatus() {
        return status;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void addRequiredResource(ResourceType type, int amount) {
        if (amount > 0) {
            requiredResources.put(type, requiredResources.getOrDefault(type, 0) + amount);
        }
    }

    public Map<ResourceType, Integer> getRequiredResources() {
        return Collections.unmodifiableMap(requiredResources);
    }

    public List<ColonyAgent> getAssignedAgents() {
        return Collections.unmodifiableList(assignedAgents);
    }

    public void assign(ColonyAgent agent) {
        if (agent != null && !assignedAgents.contains(agent)) {
            assignedAgents.add(agent);
            agent.setAvailable(false);
            agent.setCurrentLocation(targetLocation);
        }
    }

    public void markAssigned(List<ColonyAgent> agents) {
        for (ColonyAgent agent : agents) {
            assign(agent);
        }
        this.status = MissionStatus.ASSIGNED;
        this.failureReason = null;
    }

    public void startMission() {
        if (this.status == MissionStatus.ASSIGNED) {
            this.status = MissionStatus.IN_PROGRESS;
        }
    }

    public void advanceOneTimeUnit(MarsColony colony) {
        if (status == MissionStatus.ASSIGNED) {
            startMission();
        }
        if (status != MissionStatus.IN_PROGRESS) {
            return;
        }

        String envError = checkEnvironmentalCompatibility(colony.getEnvironmentCondition());
        if (envError != null) {
            failMission(envError);
            return;
        }

        for (ColonyAgent agent : assignedAgents) {
            agent.onTimeStep(1);
            if (agent.isRobotic()) {
                RoboticUnit robot = (RoboticUnit) agent;
                if (robot.isDamaged()) {
                    failMission("Equipment/robotic failure: " + robot.getName() + " is damaged.");
                    return;
                }
                if (robot.getBatteryLevel() <= 0) {
                    failMission("Insufficient battery: " + robot.getName() + " battery depleted.");
                    return;
                }
            } else if (agent.isHuman()) {
                CrewMember crew = (CrewMember) agent;
                if (crew.getHealth() <= 0) {
                    failMission("Unavailable personnel: " + crew.getName() + " incapacitated.");
                    return;
                }
            }
        }

        this.elapsedTime++;
        if (this.elapsedTime >= this.totalDuration) {
            completeMission(colony);
        }
    }

    public void completeMission(MarsColony colony) {
        this.status = MissionStatus.COMPLETED;
        onMissionComplete(colony);
        releaseAgents();
    }

    public void failMission(String reason) {
        this.status = MissionStatus.FAILED;
        this.failureReason = reason;
        releaseAgents();
    }

    protected void releaseAgents() {
        for (ColonyAgent agent : assignedAgents) {
            agent.setAvailable(true);
        }
    }

    public abstract boolean isAgentCompatible(ColonyAgent agent);

    public abstract String validateTeamAndFacilities(List<ColonyAgent> candidateAgents, MarsColony colony);

    public abstract String checkEnvironmentalCompatibility(EnvironmentCondition condition);

    protected abstract void onMissionComplete(MarsColony colony);

    public abstract String getMissionType();

    @Override
    public String toString() {
        String stateStr = (status == null) ? "UNSUBMITTED" : status.name();
        String detail = (status == MissionStatus.FAILED && failureReason != null)
                ? " (Reason: " + failureReason + ")"
                : String.format(" (Progress: %d/%d)", elapsedTime, totalDuration);
        return String.format("%s '%s' [%s] Target: %s -> %s%s",
                getMissionType(), name, id, targetLocation, stateStr, detail);
    }
}
