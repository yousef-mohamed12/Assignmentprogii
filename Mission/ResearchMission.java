package Mission;

import ColonyAgent.ColonyAgent;
import Enums.EnvironmentCondition;
import Equipment.Equipment;
import Facility.Laboratory;
import java.util.List;

public class ResearchMission extends Mission {

    private String requiredSkill;
    private Laboratory laboratory;
    private Equipment scientificEquipment;

    public ResearchMission(String id, String name, String targetLocation, int totalDuration,
                           String requiredSkill, Laboratory laboratory,
                           Equipment scientificEquipment) {
        super(id, name, targetLocation, totalDuration);
        this.requiredSkill = requiredSkill;
        this.laboratory = laboratory;
        this.scientificEquipment = scientificEquipment;
    }

    @Override
    public boolean isAgentCompatible(ColonyAgent a) {
        
    }

    @Override
    public String validateTeamAndFacilities(List<ColonyAgent> a, MarsColony c) {
       
    }

    // Required by Mission; not shown in the UML for this class
    @Override
    public String checkEnvironmentalCompatibility(EnvironmentCondition e) {
        
    }

    @Override
    protected void onMissionComplete(MarsColony c) {
    }

    @Override
    public String getMissionType() {
        return "ResearchMission";
    }
}