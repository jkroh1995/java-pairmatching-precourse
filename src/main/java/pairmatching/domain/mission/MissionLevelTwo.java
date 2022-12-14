package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.List;

public enum MissionLevelTwo {

    CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도");

    private static final String ERROR_MISSION = "[ERROR] 해당 레벨에 존재하지 않는 미션입니다.";
    private final String mission;

    MissionLevelTwo(String mission){
        this.mission = mission;
    }

    public static List<Mission> getMissionList() {
        List<Mission>missionList = new ArrayList<>();
        for(MissionLevelTwo mission : MissionLevelTwo.values()) {
            missionList.add(new Mission(mission.getMission()));
        }
        return missionList;
    }

    public String getMission(){
        return mission;
    }

    public static void validate(String inputMission) {
        for(MissionLevelTwo mission : MissionLevelTwo.values()) {
            if(mission.getMission().equals(inputMission)) {
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_MISSION);
    }
}
