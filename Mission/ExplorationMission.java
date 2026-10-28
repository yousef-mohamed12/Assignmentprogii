package Mission;

import ColonyAgent.ColonyAgent;
import Enums.EnvironmentCondition;
import Equipment.Equipment;
import java.util.List;

public class ExplorationMission extends Mission {

    private String requiredScientificSkill;
    private int minimumRoverBattery;
    private Equipment requiredEquipment;

    public ExplorationMission(String id, String name, String targetLocation, int totalDuration,
                              String requiredScientificSkill, int minimumRoverBattery,
                              Equipment requiredEquipment) {
        super(id, name, targetLocation, totalDuration);
        this.requiredScientificSkill = requiredScientificSkill;
        this.minimumRoverBattery = minimumRoverBattery;
        this.requiredEquipment = requiredEquipment;
    }


    public boolean isAgentCompatible(ColonyAgent a) {
        return false;
    }

   
    public String checkEnvironmentalCompatibility(EnvironmentCondition e) {
        
    }

   
    public String validateTeamAndFacilities(List<ColonyAgent> a, MarsColony c) {
       
    }


    protected void onMissionComplete(MarsColony c) {
    }


    public String getMissionType() {
        return "ExplorationMission";
    }
}