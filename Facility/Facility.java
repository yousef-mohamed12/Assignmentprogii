package Facility;

import Enums.FacilityStatus;
import Enums.ResourceType;
import Equipment.Equipment;

import java.util.Map;
import java.util.List;

public abstract class Facility {
    protected String id, name, location;
    protected int capacity;
    protected FacilityStatus status;
    protected final Map<ResourceType, Integer> resources;
    protected List<Equipment> equipmentlist;

    public Facility(String id, String name, String location, int capacity, FacilityStatus status,
            Map<ResourceType, Integer> resources, List<Equipment> equipmentlist) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.status = status;
        this.resources = resources;
        this.equipmentlist = equipmentlist;
    }
    

    public boolean isOperational(){

    }
    public int getReasourceQuantity(ResourceType type){
        
    }
    public void addReasourceQuantity(ResourceType type, int amout){

    }
    public void deductReasource(){

    }
    public void addEquipment(Equipment eq){

    }
    public abstract String getFacilityType();


    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getLocation() {
        return location;
    }


    public int getCapacity() {
        return capacity;
    }


    public FacilityStatus getStatus() {
        return status;
    }


    public Map<ResourceType, Integer> getResources() {
        return resources;
    }


    public List<Equipment> getEquipmentlist() {
        return equipmentlist;
    }

    
}
