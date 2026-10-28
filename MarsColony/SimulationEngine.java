package MarsColony;

public class SimulationEngine {
    private MarsColony colony;
    private  int currentTime;
    public SimulationEngine(MarsColony colony){
        this.colony = colony;
        this.currentTime = 0;
    }
    public void simulationEngine(){

    }
    public void advancetime(int units){

    }
    public void printColonyStatusReport(){

    }
    public int getCurrentTime(){
        return this.currentTime;
    }
}
