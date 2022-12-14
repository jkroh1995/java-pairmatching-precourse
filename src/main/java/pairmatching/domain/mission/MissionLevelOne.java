package pairmatching.domain.mission;

public enum MissionLevelOne {

    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임");

    private String mission;

    MissionLevelOne(String mission){
        this.mission = mission;
    }

    public String getMission(){
        return mission;
    }
}
