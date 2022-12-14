package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.List;

public class Missions {

    List<MissionList> missions  = new ArrayList<>();

    public void addMissionList(MissionList missionList){
        missions.add(missionList);
    }

    public MissionList getMissionList(int i){
        return missions.get(i);
    }

    public int size() {
        return missions.size();
    }
}
