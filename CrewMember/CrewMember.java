package CrewMember;

import java.util.HashSet;
import java.util.Set;

import ColonyAgent.ColonyAgent;
import Enums.*;

public abstract class CrewMember extends ColonyAgent {
    protected int fatigueLevel;
    protected Set<Skills> skills;

    public CrewMember(String id, String name,String currentLocation, Set<Capability> capabilities,  Set<Skills> skills){
        super(id, name,currentLocation, capabilities);
        this.fatigueLevel = 0;
        this.skills = new HashSet<>(skills);

    }

    public boolean hasSkill(Skills skill){
        return this.skills.contains(skill);
    }
    public void increaseFatigue(int amt){
        //amt cannot be less than zero
        if(this.fatigueLevel + amt > 100)
            this.fatigueLevel = 100;
        else
            this.fatigueLevel += amt;
        isOperationalAndHealthy();
    }
    public void rest(int amt){
        //amt cannot be less than zero
        if(this.fatigueLevel - amt < 0){
            this.fatigueLevel = 0;    
        }
        else
            this.fatigueLevel -= amt;
        isOperationalAndHealthy();
    }

    @Override
    public boolean isOperationalAndHealthy() {
        if( this.health >= 60 && this.fatigueLevel <= 40 ){
            this.available = true;
            return true;
        }
        else{
            this.available = false;
            return false;
        }
            
    }
    public boolean isHuman() {
      return true;
   }

   public boolean isRobotic() {
      return false;
   }
    @Override
    public void onTimeStep(int units) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onTimeStep'");
    }
    
    public abstract String getRoleName();

 
}
