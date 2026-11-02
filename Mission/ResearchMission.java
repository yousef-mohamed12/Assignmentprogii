package Mission;

import java.util.List;

import Enums.*;
import ColonyAgent.ColonyAgent;
import MarsColony.*;
import CrewMember.*;
import Facility.*;
import Equipment.Equipment;

public class ResearchMission extends Mission {
    private final String requiredSkill;
    private final Laboratory laboratory;
    private final Equipment scientificEquipment;

    public ResearchMission(String id, String name, int duration,
            String requiredSkill, Laboratory laboratory,
            Equipment scientificEquipment) {
        super(id, name, laboratory != null ? laboratory.getName() : "Laboratory", duration);
        this.requiredSkill = requiredSkill;
        this.laboratory = laboratory;
        this.scientificEquipment = scientificEquipment;
    }

    @Override
    public boolean isAgentCompatible(ColonyAgent agent) {
        if (!agent.hasCapability(Capability.SCIENTIFIC_RESEARCH)) {
            return false;
        }
        if (agent.isHuman()) {
            return ((CrewMember) agent).hasSkill(requiredSkill);
        }
        return false;
    }

    @Override
    public String validateTeamAndFacilities(List<ColonyAgent> candidateAgents, MarsColony colony) {
        if (laboratory == null || !laboratory.isOperational()) {
            return "Target laboratory is not operational.";
        }
        if (scientificEquipment == null || !scientificEquipment.isOperational()) {
            return "Required scientific equipment is missing or damaged.";
        }
        boolean hasQualifiedScientist = false;
        for (ColonyAgent agent : candidateAgents) {
            if (!agent.canPerform(this)) {
                return "no Agent possess the required capability.";
            }
            hasQualifiedScientist = true;
        }
        if (!hasQualifiedScientist) {
            return "Research mission requires at least one scientist with skill '" + requiredSkill + "'.";
        }
        return null;
    }

    @Override
    public String checkEnvironmentalCompatibility(EnvironmentCondition condition) {
        return null;
    }

    @Override
    protected void onMissionComplete(MarsColony colony) {

    }

    @Override
    public String getMissionType() {
        return "ResearchMission";
    }
}
