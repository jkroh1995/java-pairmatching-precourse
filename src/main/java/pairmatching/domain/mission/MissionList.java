package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.List;

public class MissionList {

    List<Mission> missionList;

    public MissionList(List<Mission> missionList) {
        this.missionList = missionList;
    }

    public List<String> getMissionNames() {
        List<String>missionNames = new ArrayList<>();
        for (Mission mission : missionList) {
            missionNames.add(mission.getMission());
        }
        return missionNames;
    }
}
