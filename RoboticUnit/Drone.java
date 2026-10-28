package RoboticUnit;


import Enums.Capability;
import java.util.Set;

public class Drone extends RoboticUnit {

    public Drone(String id, String name, int health, String currentLocation,
                 Set<Capability> capabilities, int batteryLevel) {
        super(id, name, health, currentLocation, capabilities, batteryLevel);
    }

    public boolean isAffectedByDustStorm() {
        return true; // cannot fly in a dust storm
    }

    public boolean isAffectedByCommDisruption() {
        return true; // relies on a live comm link
    }


    public void performDuty() {
        if (!isOperationalAndHealthy()) return;
        consumeBattery(5);
    }

    public String getRobotType() {
        return "Drone";
    }
}
