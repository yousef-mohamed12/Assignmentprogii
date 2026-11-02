package Enums;

public enum EnvironmentCondition {
    NORMAL("Normal Conditions"),
    DUST_STORM("Dust Storm"),
    COMMUNICATION_DISRUPTION("Communication Disruption");

    private final String description;

    EnvironmentCondition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
