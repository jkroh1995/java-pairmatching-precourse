package pairmatching.controller.domain;

import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.EachLevelMission;
import pairmatching.domain.mission.Levels;
import pairmatching.domain.mission.Missions;
import pairmatching.domain.mission.UserSelect;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MissionController {

    Missions missions = new Missions();
    EachLevelMission eachLevelMission = new EachLevelMission();
    Levels levels = new Levels();
    UserSelect userSelect;

    public void printCourseAndMission(OutputView outputView) {
        outputView.printCourseAndMission(Course.getCourses(), eachLevelMission.getAllMissions());
    }

    public void makeMissions() {
        eachLevelMission.addLevelOneMission(levels.get(0), missions.getLevelOneMissions());
        eachLevelMission.addLevelTwoMission(levels.get(1), missions.getLevelTwoMissions());
        eachLevelMission.addLevelThreeMission(levels.get(2), missions.getLevelThreeMissions());
        eachLevelMission.addLevelFourMission(levels.get(3), missions.getLevelFourMissions());
        eachLevelMission.addLevelFiveMission(levels.get(4), missions.getLevelFiveMissions());
    }

    public boolean isBackEnd() {
        return userSelect.getCourse().equals(userSelect.getCourse().getBackend());
    }

    public void makeUserSelect(InputView inputView) {
        this.userSelect = inputView.readUserSelect();
    }

    public UserSelect getUserSelect() {
        return userSelect;
    }

    public Course getBackend() {
        return userSelect.getCourse().getBackend();
    }

    public Course getFrontend() {
        return userSelect.getCourse().getFrontend();
    }
}
