package Emergency;

import Enums.EmergencyType;
import MarsColony.MarsColony;
import Mission.RepairMission;
import RoboticUnit.ExplorationRover;

public class RoverBreakdownEmergency extends Emergency {

    private ExplorationRover brokenRover;
    private boolean dispatchImmediateFieldRepair;

    public RoverBreakdownEmergency(String id, EmergencyType type, String location,
                                   ExplorationRover brokenRover,
                                   boolean dispatchImmediateFieldRepair) {
        super(id, type, location);
        this.brokenRover = brokenRover;
        this.dispatchImmediateFieldRepair = dispatchImmediateFieldRepair;
    }

    @Override
    public boolean handle(MarsColony colony) {
        return false;
    }

    public RepairMission createFollowUpRepairMission(String id, int d) {
        return null;
    }
}
