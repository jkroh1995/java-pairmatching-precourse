package pairmatching.view;

import java.util.List;
import pairmatching.domain.mission.Course;
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
    private static final String PRINT_REMATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
            + "네 | 아니오";
    private static final String PRINT_REQUIRE = "과정, 레벨, 미션을 선택하세요.";
    private static final String PRINT_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String PRINT_INITIALIZE = "초기화 되었습니다.";
    private static final String PRINT_ALERT_RESULT = "페어 매칭 결과입니다.";
    private static final String DIVIDE = " | ";
    private static final String COLON = " : ";

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

    public void printRequire() {
        System.out.println(PRINT_REQUIRE);
        System.out.println(PRINT_EXAMPLE);
    }

    public void printRematching() {
        System.out.println(PRINT_REMATCHING);
    }

    public void printPair(List<List<String>> pair) {
        System.out.println(PRINT_ALERT_RESULT);
        for (List<String> eachPair : pair) {
            System.out.println(String.join(COLON, eachPair));
        }
    }

    public void printInitialize() {
        System.out.println(PRINT_INITIALIZE);
    }

    private void printMission(List<String> levels, Missions missions) {
        System.out.println(PRINT_MISSION);
        for (int i = 0; i < missions.size(); i++) {
            System.out.println(levels.get(i) + String.join(DIVIDE, missions.getMissionList(i).getMissionNames()));
        }
    }

    private void printCourse() {
        System.out.printf(PRINT_COURSE, Course.getCourses());
    }

    private void printBlock() {
        System.out.println(PRINT_BLOCK);
    }
}
