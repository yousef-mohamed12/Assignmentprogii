package CrewMember;

import java.util.HashSet;
import java.util.Set;

import ColonyAgent.ColonyAgent;
import Enums.*;

public abstract class CrewMember extends ColonyAgent {
    protected int fatigueLevel;
    protected Set<Skills> skills;

    public CrewMember(String id, String name, int health, String currentLocation, Set<Capability> capabilities, int fatigueLevel, Set<Skills> skills){
        super(id, name, health, currentLocation, capabilities);
        setFatigueLevel(fatigueLevel);
        this.skills = new HashSet<>(skills);
        this.available = true;
    }
    
    public void setFatigueLevel(int fatigueLevel){
        if (fatigueLevel <= 0 || fatigueLevel > 100)
            System.out.println(" Fatigue Level must be larger than 0 and less than or equal to 100 ");
        else
            this.fatigueLevel = fatigueLevel;
    }
    public void setAvailable(boolean availabile){
        this.available = availabile;
    }

    

    public boolean hasSkill(String skill){
        if (skill in this.skills){
            return true;
        }
        else
            return false;
    }
    public void increaseFatigue(int amt){
        //amt cannot be less than zero
        if(this.fatigueLevel + amt > 100){
            this.fatigueLevel = 100;
            this.available = false; //may he rest in peace
        }
        else if(this.fatigueLevel + amt >= 80 && this.inMission){
            this.fatigueLevel += amt;
            this.available = false;
        }
    }
    public void rest(int amt){
        // validation 0< amt < 100 and the sum of fatiguelevel-amt??
    }

    @Override
    public boolean isOperationalAndHealthy() {
        if( this.health >= 60 && this.fatigueLevel <= 40)
            return true;
        else
            return false;
    }

    @Override
    public void onTimeStep(int units) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onTimeStep'");
    }
    
    public abstract String getRoleName();

 
}
