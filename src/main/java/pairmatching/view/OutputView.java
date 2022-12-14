package pairmatching.view;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.mission.Missions;

public class OutputView {

    private static final String PRINT_OPERATION = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";
    private static final String PRINT_BLOCK = "#############################################";
    private static final String PRINT_MISSION = "미션:";
    private static final String PRINT_COURSE = "과정: %s\n";
    private static final String DIVIDE = " | ";

    public void printOperation() {
        System.out.println(PRINT_OPERATION);
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printCourseAndMission(List<String> levels, Missions missions) {
        printBlock();
        printCourse();
        printMission(levels, missions);
        printBlock();
    }

    private void printMission(List<String> levels, Missions missions) {
        System.out.println(PRINT_MISSION);
        for(int i=0;i<missions.getMissionList().size();i++){
            System.out.println(levels.get(i)+String.join(DIVIDE, missions.getMissionList().get(i)));
        }
    }

    private void printCourse() {
        System.out.printf(PRINT_COURSE, Course.getCourses());
    }

    private void printBlock() {
        System.out.println(PRINT_BLOCK);
    }
}
