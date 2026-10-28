package RoboticUnit;

import ColonyAgent.ColonyAgent;
import Enums.Capability;
import java.util.Set;

public abstract class RoboticUnit extends ColonyAgent {

    protected int batteryLevel;
    protected boolean damaged;

    public RoboticUnit(String id, String name, int health, String currentLocation,
                       Set<Capability> capabilities, int batteryLevel) {
        super(id, name, health, currentLocation, capabilities);
        this.batteryLevel = Math.max(0, Math.min(100, batteryLevel));
        this.damaged = false;
    }

    public void consumeBattery(int amt) {
        if (amt <= 0) return;
        batteryLevel = Math.max(0, batteryLevel - amt);
    }

    public void rechargeBattery(int amt) {
        if (amt <= 0) return;
        batteryLevel = Math.min(100, batteryLevel + amt);
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    @Override
    public boolean isOperationalAndHealthy() {
        return !damaged && batteryLevel > 0 && health > 0;
    }

    /** Idle drain: 1 battery point per time unit. */
    @Override
    public void onTimeStep(int units) {
        consumeBattery(units);
    }

    public abstract String getRobotType();
}
