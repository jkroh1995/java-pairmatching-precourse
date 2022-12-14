package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.List;

public enum MissionLevelOne {

    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임");

    private static final String ERROR_MISSION = "[ERROR] 해당 레벨에 존재하지 않는 미션입니다.";
    private final String mission;

    MissionLevelOne(String mission){
        this.mission = mission;
    }

    public static List<Mission> getMissionList() {
        List<Mission>missionList = new ArrayList<>();
        for(MissionLevelOne mission : MissionLevelOne.values()) {
            missionList.add(new Mission(mission.getMission()));
        }
        return missionList;
    }

    public String getMission(){
        return mission;
    }

    public static void validate(String inputMission) {
        for(MissionLevelOne mission : MissionLevelOne.values()) {
            if(mission.getMission().equals(inputMission)) {
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_MISSION);
    }
}
