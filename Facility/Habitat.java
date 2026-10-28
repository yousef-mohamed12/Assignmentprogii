package Facility;

import java.util.List;
import java.util.Map;

import Enums.FacilityStatus;
import Enums.ResourceType;
import Equipment.Equipment;

public class Habitat extends Facility {
    private final LifeSupportSystem lifeSupport;
    public Habitat(String id, String name, String location, int capacity, FacilityStatus status,
            Map<ResourceType, Integer> resources, List<Equipment> equipmentlist , LifeSupportSystem lifeSupport) {
        super(id, name, location, capacity, status, resources, equipmentlist);
        this.lifeSupport = lifeSupport;
    }

    public void deductOxygen(int amt){

    }
    public void repairHabitat(){

    }
    public void getLifeSupport(){
        
    }
    @Override
    public String getFacilityType() {
        return "Habitat";
    }

}
