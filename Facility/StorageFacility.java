package Facility;

import java.util.List;
import java.util.Map;

import Enums.FacilityStatus;
import Enums.ResourceType;
import Equipment.Equipment;

public class StorageFacility extends Facility {
    private int maxStorageUnits;

    public StorageFacility(String id, String name, String location, int capacity, FacilityStatus status,
            Map<ResourceType, Integer> resources, List<Equipment> equipmentlist, int maxStorageUnits) {
        super(id, name, location, capacity, status, resources, equipmentlist);
        if (maxStorageUnits <=0) 
            throw new IllegalArgumentException("Invalid maxStorageUnits for StorageFacility object");
        this.maxStorageUnits = maxStorageUnits;
    }

    @Override
    public String getFacilityType() {
        return "StorageFacility";
    }

    public int getMaxStorageUnits() {
        return maxStorageUnits;
    }
    
}
