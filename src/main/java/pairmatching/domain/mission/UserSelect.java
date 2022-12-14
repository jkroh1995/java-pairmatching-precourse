package pairmatching.domain.mission;

import java.util.Arrays;

public class UserSelect {

    private static final String ERROR_NO_MISSION = "[ERROR] 해당 레벨에는 미션이 없습니다.";

    String[] userSelect;

    public UserSelect(String[] userSelect) {
        this.userSelect = userSelect;
        validate();
    }

    public String getCourse() {
        return userSelect[0];
    }

    public String getUserSelect() {
        return Arrays.toString(userSelect);
    }

    private void validate() {
        validateCourse();
        validateLevel();
        validateMission();
    }

    private void validateMission() {
        validateLevelOneMission();
        validateLevelTwoMission();
        validateLevelThreeMission();
        validateLevelFourMission();
        validateLevelFiveMission();
    }

    private void validateLevelFourMission() {
        if (userSelect[1].equals(Level.LEVEL4.getLevel())) {
            MissionLevelFour.validate(userSelect[2]);
        }
    }

    private void validateLevelTwoMission() {
        if (userSelect[1].equals(Level.LEVEL2.getLevel())) {
            MissionLevelTwo.validate(userSelect[2]);
        }
    }

    private void validateLevelOneMission() {
        if (userSelect[1].equals(Level.LEVEL1.getLevel())) {
            MissionLevelOne.validate(userSelect[2]);
        }
    }

    private void validateLevel() {
        Level.validate(userSelect[1]);
    }

    private void validateCourse() {
        Course.validate(userSelect[0]);
    }

    private void validateLevelFiveMission() {
        if (userSelect[1].equals(Level.LEVEL5.getLevel())) {
            throw new IllegalArgumentException(ERROR_NO_MISSION);
        }
    }

    private void validateLevelThreeMission() {
        if (userSelect[1].equals(Level.LEVEL3.getLevel())) {
            throw new IllegalArgumentException(ERROR_NO_MISSION);
        }
    }
}
