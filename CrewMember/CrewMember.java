package CrewMember;
import java.util.Set;

import ColonyAgent.ColonyAgent;
import Enums.Capability;

public abstract class CrewMember extends ColonyAgent {
    protected int fatigueLevel;
    protected String [] skills;

    public CrewMember(String id, String name, int health, String currentLocation, boolean availabile, Set<Capability> capabilities, int fatigueLevel, String [] skills){
        super(id, name, health, currentLocation, availabile, capabilities);
        setHealth(health);
        setAvailable(availabile);
    }
    public void setHealth(int health){
        if (health <= 0 || health > 100)
            System.out.println(" health must be larger than 0 and less than or equal to 100 ");
        else
            this.health = health;
    }
    public void setAvailable(boolean availabile){
        this.available = availabile;
    }
}
