package CrewMember;

import java.util.Set;

import Enums.Capability;

public class Scientist extends CrewMember{

    public Scientist(String id, String name, int health, String currentLocation, Set<Capability> capabilities,
            int fatigueLevel, Set<String> skills) {
        super(id, name, health, currentLocation, capabilities, fatigueLevel, skills);
        //TODO Auto-generated constructor stub
    }

    

    @Override
    public void performDuty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'performDuty'");
    }

    @Override
    public String getRoleName() {
        return "Scientist";
    }


}
