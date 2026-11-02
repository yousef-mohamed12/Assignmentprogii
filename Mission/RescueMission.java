package Mission;

import java.util.List;

import Enums.*;
import ColonyAgent.ColonyAgent;
import MarsColony.*;
import RoboticUnit.*;

public class RescueMission extends Mission {
    private final ColonyAgent lostAgent;

    public RescueMission(String id, String name, String targetLocation, int duration,
            ColonyAgent lostAgent) {
        super(id, name, targetLocation, duration);
        this.lostAgent = lostAgent;
    }

    public ColonyAgent getlostAgent() {
        return lostAgent;
    }

    @Override
    public boolean isAgentCompatible(ColonyAgent agent) {
        return agent.hasCapability(Capability.SEARCH_AND_RESCUE);
    }

    @Override
    public String validateTeamAndFacilities(List<ColonyAgent> candidateAgents, MarsColony colony) {
        if (!colony.hasActiveCommunicationCapability()) {
            return "Colony lacks operational communication capability for rescue coordination.";
        }
        boolean hasRescueVehicle = false;
        boolean hasRescuePersonnel = false;
        for (ColonyAgent agent : candidateAgents) {
            if (!agent.canPerform(this)) {
                return "Agent does not possess the required capability.";
            }
            if (agent.isRobotic()) {
                hasRescueVehicle = true;
            }
            if (agent.isHuman()) {
                hasRescuePersonnel = true;
            }
        }
        if (!hasRescueVehicle || !hasRescuePersonnel) {
            return "Rescue mission requires both an appropriate rescue vehicle/robot and available personnel.";
        }
        return null;
    }

    @Override
    public String checkEnvironmentalCompatibility(EnvironmentCondition condition) {
        if (condition == EnvironmentCondition.DUST_STORM) {
            return "Surface operations are not allowed during a dust storm.";
        }
        if (condition == EnvironmentCondition.COMMUNICATION_DISRUPTION) {
            return "Communication-dependent rescue missions cannot operate during a communication disruption.";
        }
        return null;
    }

    @Override
    protected void onMissionComplete(MarsColony colony) {
        if (lostAgent != null) {
            lostAgent.setCurrentLocation("Habitat Alpha");
            if (lostAgent.isRobotic()) {
                ((RoboticUnit) lostAgent).setDamaged(false);
            } else if (lostAgent.isHuman()) {
                lostAgent.setHealth(Math.max(80, lostAgent.getHealth()));
            }
            lostAgent.setAvailable(true);
        }
        for (ColonyAgent agent : assignedAgents) {
            agent.setCurrentLocation("Habitat Alpha");
        }
    }

    @Override
    public String getMissionType() {
        return "RescueMission";
    }
}
