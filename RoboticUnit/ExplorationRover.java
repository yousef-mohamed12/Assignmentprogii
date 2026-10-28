package RoboticUnit;


import Enums.Capability;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExplorationRover extends RoboticUnit {

    private List<Equipment> carriedEquipment;

    public ExplorationRover(String id, String name, int health, String currentLocation,
                            Set<Capability> capabilities, int batteryLevel) {
        super(id, name, health, currentLocation, capabilities, batteryLevel);
        this.carriedEquipment = new ArrayList<>();
    }

    public void loadEquipment(Equipment eq) {
        if (eq != null) carriedEquipment.add(eq);
    }

    public boolean isAffectedByDustStorm() {
        return true; // surface rovers are slowed/blocked by dust storms
    }

    @Override
    public void performDuty() {
        if (!isOperationalAndHealthy()) return;
        consumeBattery(10);
    }

    @Override
    public String getRobotType() {
        return "ExplorationRover";
    }
}
