package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import pairmatching.domain.Operation;
import pairmatching.domain.mission.EachLevelMission;
import pairmatching.domain.mission.Level;
import pairmatching.domain.mission.Missions;

public class OutputView {

    private static final String PRINT_OPERATION = "기능을 선택하세요.";
    private static final String PRINT_BLOCK = "#############################################";
    private static final String PRINT_COURSE = "과정: %s\n";
    private static final String PRINT_REMATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
            + "네 | 아니오";
    private static final String PRINT_REQUIRE = "과정, 레벨, 미션을 선택하세요.";
    private static final String PRINT_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String PRINT_INITIALIZE = "초기화 되었습니다.";
    private static final String PRINT_ALERT_RESULT = "페어 매칭 결과입니다.";
    private static final String COLON = " : ";

    public void printOperation() {
        System.out.println(PRINT_OPERATION);
        for(Operation operation : Operation.values()){
            System.out.println(operation.getOperationIndex() + operation.getOperation());
        }
    }

    public void printError(String message) {
        System.out.println(message);
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

    public void printCourseAndMission(String course, Map<Level, Missions> missions) {
        printBlock();
        printCourse(course);
        printMission(missions);
        printBlock();
    }

    private void printCourse(String course) {
        System.out.printf(PRINT_COURSE, course);
    }

    private void printBlock() {
        System.out.println(PRINT_BLOCK);
    }

    private void printMission(Map<Level, Missions> missions) {
        for(Level level : missions.keySet()){
            System.out.println(level.toString()+ missions.get(level).toString());
        }
    }
}
