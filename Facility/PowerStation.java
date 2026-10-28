package Facility;

import java.util.List;
import java.util.Map;

import Enums.FacilityStatus;
import Enums.ResourceType;
import Equipment.Equipment;

public class PowerStation extends Facility {
    private int powerGenerationRateKW;

    public PowerStation(String id, String name, String location, int capacity, FacilityStatus status,
            Map<ResourceType, Integer> resources, List<Equipment> equipmentlist, int powerGenerationRateKW) {
        super(id, name, location, capacity, status, resources, equipmentlist);
        if(powerGenerationRateKW <= 0)
            throw new IllegalArgumentException("Invalid units for the PowerStation object");
        this.powerGenerationRateKW = powerGenerationRateKW;
    }

    @Override
    public String getFacilityType() {
        return "PowerStation";
    }
    public void generatePower(int units){
        if(powerGenerationRateKW <= 0)
            throw new IllegalArgumentException("Invalid units for the PowerStation object");
        this.powerGenerationRateKW += units;
    } 
    

}
