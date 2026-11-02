package Mission;

import java.util.List;

import Enums.*;
import ColonyAgent.ColonyAgent;
import MarsColony.*;
import RoboticUnit.*;
import Facility.*;
import Equipment.Equipment;

public class RepairMission extends Mission {
    private final Facility targetFacility;
    private final Equipment targetEquipment;
    private final RoboticUnit targetBrokenRobot;

    public RepairMission(String id, String name, String location, int duration,
            Facility targetFacility, Equipment targetEquipment,
            RoboticUnit targetBrokenRobot, int requiredSpareParts) {
        super(id, name, location, duration);
        this.targetFacility = targetFacility;
        this.targetEquipment = targetEquipment;
        this.targetBrokenRobot = targetBrokenRobot;
        addRequiredResource(ResourceType.SPARE_PARTS, requiredSpareParts);
    }

    @Override
    public boolean isAgentCompatible(ColonyAgent agent) {
        return agent.hasCapability(Capability.EQUIPMENT_REPAIR)
                || agent.hasCapability(Capability.FACILITY_REPAIR);
    }

    @Override
    public String validateTeamAndFacilities(List<ColonyAgent> candidateAgents, MarsColony colony) {
        boolean hasHumanRepairer = false;
        boolean hasRoboticRepairer = false;

        for (ColonyAgent agent : candidateAgents) {
            if (!agent.canPerform(this)) {
                return "Agent does not possess the required capability.";
            }
            if (agent.isHuman()) {
                hasHumanRepairer = true;
            }
            if (agent.isRobotic()) {
                hasRoboticRepairer = true;
            }
        }

        if (!hasHumanRepairer || !hasRoboticRepairer) {
            return "Repair mission requires both a repair-capable engineer and a repair robot.";
        }
        return null;
    }

    @Override
    public String checkEnvironmentalCompatibility(EnvironmentCondition condition) {
        if (condition == EnvironmentCondition.DUST_STORM
                && "Martian Surface".equalsIgnoreCase(targetLocation)) {
            return "Surface operations are not allowed during a dust storm.";
        }
        return null;
    }

    @Override
    protected void onMissionComplete(MarsColony colony) {
        if (targetFacility != null && targetFacility.getStatus() != FacilityStatus.DESTROYED) {
            targetFacility.setStatus(FacilityStatus.OPERATIONAL);
        }
        if (targetEquipment != null) {
            targetEquipment.repair();
        }
        if (targetBrokenRobot != null) {
            targetBrokenRobot.setDamaged(false);
            targetBrokenRobot.rechargeBattery(50);
            targetBrokenRobot.setCurrentLocation("Habitat Alpha");
        }
    }

    @Override
    public String getMissionType() {
        return "RepairMission";
    }
}
