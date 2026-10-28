package Mission;


import ColonyAgent.ColonyAgent;
import Enums.EnvironmentCondition;
import Enums.MissionStatus;
import Enums.ResourceType;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

 
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

    public Mission(String id, String name, String targetLocation, int totalDuration) {
        this.id = id;
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
    }

    public Map<ResourceType, Integer> getRequiredResources() {
        return requiredResources;
    }

    public List<ColonyAgent> getAssignedAgents() {
        return assignedAgents;
    }

    public void assign(ColonyAgent agent) {
    }

    public void markAssigned(List<ColonyAgent> agents) {
    }

    public void startMission() {
    }

    public void advanceOneTimeUnit(MarsColony colony) {
    }

    public void completeMission(MarsColony colony) {
    }

    public void failMission(String reason) {
    }

    protected void releaseAgents() {
    }

    public abstract boolean isAgentCompatible(ColonyAgent agent);

    public abstract String validateTeamAndFacilities(List<ColonyAgent> candidateAgents, MarsColony colony);

    public abstract String checkEnvironmentalCompatibility(EnvironmentCondition condition);

    protected abstract void onMissionComplete(MarsColony colony);

    public abstract String getMissionType();
}
