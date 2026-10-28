import java.util.HashSet;
import java.util.Set;

public abstract class ColonyAgent {


    protected String id;
    protected String name;
    protected int health;
    protected String currentLocation;
    protected boolean available;
    protected Set<Capability> capabilities;


    protected ColonyAgent(String id, String name, int health,
                          String currentLocation, Set<Capability> capabilities) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.currentLocation = currentLocation;
        this.available = true;
        this.capabilities = (capabilities != null)
                ? new HashSet<>(capabilities)
                : new HashSet<>();
    }


    public boolean canPerform(Mission mission) {

    }


    public boolean canRespondTo(Capability cap) {
       
    }


    public boolean hasCapability(Capability cap) {
       
    }


    public abstract boolean isOperationalAndHealthy();

    public abstract void onTimeStep(int units);

    public abstract void performDuty();
}