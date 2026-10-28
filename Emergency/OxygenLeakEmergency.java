package Emergency;

import Enums.EmergencyType;
import Facility.Habitat;
import MarsColony.MarsColony;

public class OxygenLeakEmergency extends Emergency {

    private Habitat affectedHabitat;
    private int leakOxygenAmount;

    public OxygenLeakEmergency(String id, EmergencyType type, String location,
                               Habitat affectedHabitat, int leakOxygenAmount) {
        super(id, type, location);
        this.affectedHabitat = affectedHabitat;
        this.leakOxygenAmount = leakOxygenAmount;
    }

    @Override
    public boolean handle(MarsColony colony) {
        return false;
    }
}
