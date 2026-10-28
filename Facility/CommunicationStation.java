package Facility;

import java.util.List;
import java.util.Map;

import Enums.FacilityStatus;
import Enums.ResourceType;
import Equipment.Equipment;

public class CommunicationStation extends Facility{
    private boolean signalStatus;

    public CommunicationStation(String id, String name, String location, int capacity, FacilityStatus status,
            Map<ResourceType, Integer> resources, List<Equipment> equipmentlist) {
        super(id, name, location, capacity, status, resources, equipmentlist);
        this.signalStatus = true;
    }


    @Override
    public String getFacilityType() {
        return "CommunicationStation";
    }

    
    public boolean getSignalStatus() {
        return this.signalStatus;
    }


    public void setSignalStatus(boolean signalStatus) {
        this.signalStatus = signalStatus;
    }
}
