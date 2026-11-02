package Mission;

import java.util.List;

import Enums.*;
import ColonyAgent.ColonyAgent;
import MarsColony.*;
import CrewMember.*;
import RoboticUnit.*;
import Equipment.Equipment;

public class ExplorationMission extends Mission {
    private final String requiredScientificSkill;
    private final int minimumRoverBattery;
    private final Equipment requiredEquipment;

    public ExplorationMission(String id, String name, String targetRegion, int duration,
            String requiredScientificSkill, int minimumRoverBattery,
            Equipment requiredEquipment) {
        super(id, name, targetRegion, duration);
        this.requiredScientificSkill = requiredScientificSkill;
        this.minimumRoverBattery = minimumRoverBattery;
        this.requiredEquipment = requiredEquipment;
    }

    public String getRequiredScientificSkill() {
        return requiredScientificSkill;
    }

    public int getMinimumRoverBattery() {
        return minimumRoverBattery;
    }

    public Equipment getRequiredEquipment() {
        return requiredEquipment;
    }

    @Override
    public boolean isAgentCompatible(ColonyAgent agent) {

        if (agent.hasCapability(Capability.SCIENTIFIC_RESEARCH)) {
            if (agent.isHuman()) {
                return ((CrewMember) agent).hasSkill(requiredScientificSkill);
            }

        }
        if (agent.hasCapability(Capability.SURFACE_EXPLORATION)) {
            if (agent.isRobotic()) {
                return ((RoboticUnit) agent).getBatteryLevel() >= minimumRoverBattery;
            }

        }
        return false;
    }

    @Override
    public String validateTeamAndFacilities(List<ColonyAgent> candidateAgents, MarsColony colony) {
        if (requiredEquipment == null || !requiredEquipment.isOperational()) {
            return "Required exploration equipment is missing or damaged.";
        }

        boolean hasResearcherWithSkill = false;
        boolean hasExplorationVehicle = false;

        for (ColonyAgent agent : candidateAgents) {
            if (!agent.canPerform(this)) {
                return "Agent does not possess the required capability.";
            }
            if (agent.hasCapability(Capability.SCIENTIFIC_RESEARCH)) {
                hasResearcherWithSkill = true;
            }
            if (agent.hasCapability(Capability.SURFACE_EXPLORATION)) {
                hasExplorationVehicle = true;
            }
        }

        if (!hasResearcherWithSkill) {
            return "no Agent possess the required capability (missing scientific researcher with skill '"
                    + requiredScientificSkill + "').";
        }
        if (!hasExplorationVehicle) {
            return "no Agent possess the required capability (missing surface exploration vehicle with battery >= "
                    + minimumRoverBattery + "%).";
        }
        return null;
    }

    @Override
    public String checkEnvironmentalCompatibility(EnvironmentCondition condition) {
        if (condition == EnvironmentCondition.DUST_STORM) {
            return "Surface operations are not allowed during a dust storm.";
        }
        return null;
    }

    @Override
    protected void onMissionComplete(MarsColony colony) {
        for (ColonyAgent agent : assignedAgents) {
            agent.setCurrentLocation("Habitat Alpha");
        }
    }

    @Override
    public String getMissionType() {
        return "ExplorationMission";
    }
}
