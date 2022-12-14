package pairmatching.domain.mission;

public enum MissionLevelFour {

    IMPROVE("성능개선"),
    PUBLISH("배포");

    private String mission;

    MissionLevelFour(String mission){
        this.mission = mission;
    }

    public String getMission() {
        return mission;
    }
}
