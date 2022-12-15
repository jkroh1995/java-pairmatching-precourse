package pairmatching.domain.mission;

public class Mission {

    private final static String MISSION_LEVEL_1 = "자동차경주, 로또, 숫자야구게임";
    private final static String MISSION_LEVEL_2 = "장바구니, 결제, 지하철노선도";
    private final static String MISSION_LEVEL_4 = "성능개선, 배포";

    String mission;
    Level level;

    public Mission(String mission) {
        this.mission = mission;
    }

    public Mission(Level level, String mission) {
        this.mission = mission;
        this.level = level;
        validate();
    }

    public String getMission() {
        return mission;
    }

    private void validate() {
        validateLevelOne();
        validateLevelTwo();
        validateLevelThree();
        validateLevelFour();
        validateLevelFive();
    }

    private void validateLevelFive() {
        if(level.getLevel().equals("레벨5")){
            throw new IllegalArgumentException("[ERROR] 해당 레벨은 미션이 없습니다.");
        }
    }

    private void validateLevelFour() {
        if(level.getLevel().equals("레벨4")){
            if(!MISSION_LEVEL_4.contains(mission)){
                throw new IllegalArgumentException("[ERROR] 해당 레벨에 없는 미션입니다.");
            }
        }
    }

    private void validateLevelThree() {
        if(level.getLevel().equals("레벨3")){
            throw new IllegalArgumentException("[ERROR] 해당 레벨은 미션이 없습니다.");
        }
    }

    private void validateLevelTwo() {
        if(level.getLevel().equals("레벨2")){
            if(!MISSION_LEVEL_2.contains(mission)){
                throw new IllegalArgumentException("[ERROR] 해당 레벨에 없는 미션입니다.");
            }
        }
    }

    private void validateLevelOne() {
        if(level.getLevel().equals("레벨1")){
            if(!MISSION_LEVEL_1.contains(mission)){
                throw new IllegalArgumentException("[ERROR] 해당 레벨에 없는 미션입니다.");
            }
        }
    }
}
