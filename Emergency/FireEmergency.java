package Emergency;

import Enums.EmergencyType;
import Facility.Laboratory;
import MarsColony.MarsColony;

public class FireEmergency extends Emergency {

    private Laboratory affectedLaboratory;
    private int extraOxygenConsumed;

    public FireEmergency(String id, EmergencyType type, String location,
                         Laboratory affectedLaboratory, int extraOxygenConsumed) {
        super(id, type, location);
        this.affectedLaboratory = affectedLaboratory;
        this.extraOxygenConsumed = extraOxygenConsumed;
    }

    @Override
    public boolean handle(MarsColony colony) {
        return false;
    }
}
