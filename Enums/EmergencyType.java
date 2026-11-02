package Enums;

public enum EmergencyType {
    OXYGEN_LEAK("Oxygen Leak"),
    FIRE("Laboratory Fire"),
    ROVER_BREAKDOWN("Rover Breakdown"),
    MEDICAL_EMERGENCY("Medical Emergency");

    private final String displayName;

    EmergencyType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
