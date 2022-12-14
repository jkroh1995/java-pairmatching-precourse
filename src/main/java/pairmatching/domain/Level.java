package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public enum Level {

    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String level;

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
}
