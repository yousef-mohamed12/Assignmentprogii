package Emergency;

import CrewMember.CrewMember;
import Enums.EmergencyType;
import Facility.Facility;
import MarsColony.MarsColony;

public class MedicalEmergency extends Emergency {

    private CrewMember patient;
    private Facility treatmentFacility;

    public MedicalEmergency(String id, EmergencyType type, String location,
                            CrewMember patient, Facility treatmentFacility) {
        super(id, type, location);
        this.patient = patient;
        this.treatmentFacility = treatmentFacility;
    }

    @Override
    public boolean handle(MarsColony colony) {
        return false;
    }

    public CrewMember getPatient() {
        return patient;
    }
}
