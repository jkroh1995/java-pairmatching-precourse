package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.List;

public class Missions {

    List<List<String>> missions  = new ArrayList<>();

    public void addMissionList(List<String>missionList){
        missions.add(missionList);
    }

    public List<List<String>>getMissionList(){
        return missions;
    }
}
