package pairmatching.controller.domain;

import java.util.ArrayList;
import pairmatching.domain.mission.MissionLevelFour;
import pairmatching.domain.mission.MissionLevelOne;
import pairmatching.domain.mission.MissionLevelTwo;
import pairmatching.domain.mission.MissionList;
import pairmatching.domain.mission.Missions;

public class MissionController {

    Missions missions = new Missions();

    public Missions getMissions() {
        return missions;
    }

    public void makeMissions() {
        missions.addMissionList(new MissionList(MissionLevelOne.getMissionList()));
        missions.addMissionList(new MissionList(MissionLevelTwo.getMissionList()));
        missions.addMissionList(new MissionList(new ArrayList<>()));
        missions.addMissionList(new MissionList(MissionLevelFour.getMissionList()));
        missions.addMissionList(new MissionList(new ArrayList<>()));
    }
}
