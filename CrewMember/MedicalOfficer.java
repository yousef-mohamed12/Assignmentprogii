package CrewMember;

import java.util.Set;

import Enums.*;

public class MedicalOfficer extends CrewMember {

    public MedicalOfficer(String id, String name, int health, String currentLocation, Set<Capability> capabilities,
            int fatigueLevel, Set<Skills> skills) {
        super(id, name, health, currentLocation, capabilities, fatigueLevel, skills);
        //TODO Auto-generated constructor stub
    }

    public void treatPatient(CrewMember patient, int b){

    }

    @Override
    public void performDuty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'performDuty'");
    }

    @Override
    public String getRoleName() {
        return "MedicalOfficer";
    }

}
