package Facility;

import java.util.List;
import java.util.Map;

import Enums.FacilityStatus;
import Enums.ResourceType;
import Equipment.Equipment;

public class Laboratory extends Facility{
    private String researchSpeciality;
    public Laboratory(String id, String name, String location, int capacity, FacilityStatus status,
            Map<ResourceType, Integer> resources, List<Equipment> equipmentlist,String researchSpeciality) {
        if (researchSpeciality == null || researchSpeciality.trim().isEmpty()) 
            throw new IllegalArgumentException("Invalid researchSpeciality for the laboratory object");
        super(id, name, location, capacity, status, resources, equipmentlist);
        this.researchSpeciality = researchSpeciality;
    }

    @Override
    public String getFacilityType() {
        return "Laboratory";
    }

    public String getResearchSpeciality() {
        return researchSpeciality;
    }

}
