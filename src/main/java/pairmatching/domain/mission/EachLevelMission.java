package pairmatching.domain.mission;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class EachLevelMission {

    Map<Level, Missions> eachLevelMission = new LinkedHashMap<>();

    public void addLevelOneMission(Level level, Missions levelOneMissions) {
        eachLevelMission.put(level, levelOneMissions);
    }

    public void addLevelTwoMission(Level level, Missions levelTwoMissions) {
        eachLevelMission.put(level, levelTwoMissions);
    }

    public void addLevelThreeMission(Level level, Missions levelThreeMissions) {
        eachLevelMission.put(level, levelThreeMissions);
    }

    public void addLevelFourMission(Level level, Missions levelFourMissions) {
        eachLevelMission.put(level, levelFourMissions);
    }

    public void addLevelFiveMission(Level level, Missions levelFiveMissions) {
        eachLevelMission.put(level, levelFiveMissions);
    }

    public Map<Level, Missions> getAllMissions() {
        return eachLevelMission;
    }
}
