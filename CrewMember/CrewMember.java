package CrewMember;
import ColonyAgent.ColonyAgent;

public abstract class CrewMember extends ColonyAgent {
    protected int fatigueLevel;
    protected String [] skills;

    public CrewMember(String id, String name, int health, String currentLocation, boolean availabile,  int fatigueLevel, String [] skills){
        super(id, name, health, currentLocation);
        setHealth(health);
    }
    public int setHealth(int health){
        if (health <= 0 || health > 100)
            System.out.println(" health must be larger than 0 and less than or equal to 100 ");
        else
            this.health = health;
    }
}
