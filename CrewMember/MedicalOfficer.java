package CrewMember;

import java.util.Set;

import Enums.*;

public class MedicalOfficer extends CrewMember {

    public MedicalOfficer(String id, String name, String currentLocation, Set<Capability> capabilities,
             Set<Skills> skills) {
        super(id, name, currentLocation, capabilities, skills);
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
