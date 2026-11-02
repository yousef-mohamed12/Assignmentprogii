package Enums;

public enum ResourceType {
    OXYGEN("Oxygen", "units"),
    WATER("Water", "liters"),
    FOOD("Food", "rations"),
    FUEL("Fuel", "liters"),
    BATTERY_POWER("Battery Power", "kWh"),
    MEDICAL_SUPPLIES("Medical Supplies", "kits"),
    SPARE_PARTS("Spare Parts", "parts");

    private final String displayName;
    private final String unit;

    ResourceType(String displayName, String unit) {
        this.displayName = displayName;
        this.unit = unit;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
