package CrewMember;

import java.util.Set;

import Enums.Capability;

public class Scientist extends CrewMember{

    public Scientist(String id, String name, int health, String currentLocation, Set<Capability> capabilities,
            int fatigueLevel, String[] skills) {
        super(id, name, health, currentLocation, capabilities, fatigueLevel, skills);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean isOperationalAndHealthy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOperationalAndHealthy'");
    }

    @Override
    public void onTimeStep(int units) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onTimeStep'");
    }

    @Override
    public void performDuty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'performDuty'");
    }


}
