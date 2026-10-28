package Mission;

import ColonyAgent.ColonyAgent;
import Enums.EnvironmentCondition;
import Equipment.Equipment;
import Facility.Facility;
import RoboticUnit.RoboticUnit;
import java.util.List;

public class RepairMission extends Mission {

    private Facility targetFacility;
    private Equipment targetEquipment;
    private RoboticUnit targetBrokenRobot;

    public RepairMission(String id, String name, String targetLocation, int totalDuration,
                         Facility targetFacility, Equipment targetEquipment,
                         RoboticUnit targetBrokenRobot) {
        super(id, name, targetLocation, totalDuration);
        this.targetFacility = targetFacility;
        this.targetEquipment = targetEquipment;
        this.targetBrokenRobot = targetBrokenRobot;
    }

    @Override
    public boolean isAgentCompatible(ColonyAgent a) {
     
    }

    @Override
    protected void onMissionComplete(MarsColony c) {
    }


    @Override
    public String validateTeamAndFacilities(List<ColonyAgent> a, MarsColony c) {
      
    }

    @Override
    public String checkEnvironmentalCompatibility(EnvironmentCondition e) {
        
    }

    @Override
    public String getMissionType() {
        return "RepairMission";
    }
}