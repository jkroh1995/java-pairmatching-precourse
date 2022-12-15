package pairmatching.domain.mission;

import java.util.Arrays;
import java.util.List;

public class Level {

    private static final String ERROR_LEVEL = "[ERROR] 존재하지 않는 레벨입니다.";
    private static final String LEVEL1 = "레벨1";
    private static final String LEVEL2 = "레벨2";
    private static final String LEVEL3 = "레벨3";
    private static final String LEVEL4 = "레벨4";
    private static final String LEVEL5 = "레벨5";

    String level;

    public Level(String level) {
        this.level = level;
        validate();
    }

    public String getLevel() {
        return level;
    }

    private void validate() {
        List<String> levelList = Arrays.asList(LEVEL1, LEVEL2, LEVEL3, LEVEL4, LEVEL5);
        for (String eachLevel : levelList) {
            if (eachLevel.equals(level)) {
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_LEVEL);
    }

    public String toString() {
        return "  - "
                + level
                + ": ";
    }
}
