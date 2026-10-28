package MarsColony;
import java.util.List;

import CrewMember.*;
import Emergency.*;
import Enums.*;
import Facility.*;
import Mission.*;
import RoboticUnit.*;

public class MarsColony {
    private final String colonyName;
    private final List<CrewMember> crew;
    private final List<RoboticUnit> robots;
    private final List<Facility> facilities;
    private final List<Mission> missionHistory;
    private final List<Emergency> emergencyHistory;
    private Mission activeMission;
    private EnvironmentCondition environmentCondition;
    
    public MarsColony(String colonyName, List<CrewMember> crew, List<RoboticUnit> robots, List<Facility> facilities,
            List<Mission> missionHistory, List<Emergency> emergencyHistory, Mission activeMission,
            EnvironmentCondition environmentCondition) {
        this.colonyName = colonyName;
        this.crew = crew;
        this.robots = robots;
        this.facilities = facilities;
        this.missionHistory = missionHistory;
        this.emergencyHistory = emergencyHistory;
        this.activeMission = activeMission;
        this.environmentCondition = environmentCondition;
    }
}
