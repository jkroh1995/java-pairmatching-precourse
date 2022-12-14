package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.List;

public class MissionList {


    public List<String> getLevelOneMissionList(){
        List<String> missionList = new ArrayList<>();
        for(MissionLevelOne mission : MissionLevelOne.values()){
            missionList.add(mission.getMission());
        }
        return missionList;
    }

    public List<String> getLevelTwoMissionList(){
        List<String> missionList = new ArrayList<>();
        for(MissionLevelTwo mission : MissionLevelTwo.values()){
            missionList.add(mission.getMission());
        }
        return missionList;
    }

    public List<String> getLevelThreeMissionList(){
        return new ArrayList<>();
    }

    public List<String> getLevelFourMissionList(){
        List<String> missionList = new ArrayList<>();
        for(MissionLevelFour mission : MissionLevelFour.values()){
            missionList.add(mission.getMission());
        }
        return missionList;
    }

    public List<String> getLevelFiveMissionList(){
        return new ArrayList<>();
    }

}
