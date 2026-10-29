package CrewMember;

import java.util.Set;

import Enums.*;
import Mission.Mission;

public class Engineer extends CrewMember {

    public Engineer(String id, String name, String currentLocation, Set<Capability> capabilities,
            Set<Skills> skills) {
                
        super(id, name, currentLocation, capabilities, skills);
        //TODO Auto-generated constructor stub
    }

    public void repair(Mission mission){

    }
    @Override
    public void performDuty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'performDuty'");
    }

    @Override
    public String getRoleName() {
        return "Engineer";
    }

}
