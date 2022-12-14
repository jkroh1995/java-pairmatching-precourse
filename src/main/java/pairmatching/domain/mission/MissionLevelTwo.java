package pairmatching.domain.mission;

public enum MissionLevelTwo {

    CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도");

    private String mission;

    MissionLevelTwo(String mission){
        this.mission = mission;
    }

    public String getMission(){
        return mission;
    }
}
