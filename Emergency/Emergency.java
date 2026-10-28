package Emergency;

import ColonyAgent.ColonyAgent;
import Enums.EmergencyStatus;
import Enums.EmergencyType;
import Enums.ResourceType;
import MarsColony.MarsColony;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public abstract class Emergency {
    protected String id;
    protected EmergencyType type;
    protected String location;
    protected EmergencyStatus status;
    protected String resolutionDetails;
    protected List<ColonyAgent> dispatchedResponders;
    protected Map<ResourceType, Integer> requiredResources;

    public Emergency(String id, EmergencyType type, String location) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.status = null;
        this.resolutionDetails = null;
        this.dispatchedResponders = new ArrayList<>();
        this.requiredResources = new EnumMap<>(ResourceType.class);
    }

    protected void dispatchResponder(ColonyAgent r) {
    }

    protected void releaseResponders() {
    }

    public abstract boolean handle(MarsColony colony);
}
