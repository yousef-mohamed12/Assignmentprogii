package RoboticUnit;
import Enums.Capability;
import java.util.Set;

public class RepairRobot extends RoboticUnit {

    public RepairRobot(String id, String name, int health, String currentLocation,
                       Set<Capability> capabilities, int batteryLevel) {
        super(id, name, health, currentLocation, capabilities, batteryLevel);
    }

    public boolean isAffectedByDustStorm() {
        return true;
    }


    public void performDuty() {
        if (!isOperationalAndHealthy()) return;
        consumeBattery(8);
    }


    public String getRobotType() {
        return "RepairRobot";
    }
}
