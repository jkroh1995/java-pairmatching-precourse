package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.List;

public enum Level {

    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private static final String ERROR_LEVEL = "[ERROR] 존재하지 않는 레벨입니다.";
    private final String level;

    Level(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public static List<String> getLevels() {
        List<String> levels = new ArrayList<>();
        for (Level level : Level.values()) {
            levels.add("  - " + level.getLevel() + ": ");
        }
        return levels;
    }

    public static void validate(String inputLevel) {
        for(Level level : Level.values()) {
            if(level.getLevel().equals(inputLevel)) {
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_LEVEL);
    }
}
