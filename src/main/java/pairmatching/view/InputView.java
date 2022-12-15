package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Operation;
import pairmatching.domain.RematchingIndex;
import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Level;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.mission.UserSelect;

public class InputView {

    OutputView outputView = new OutputView();

    public Operation readOperation() {
        try {
            outputView.printOperation();
            String inputOperation = Console.readLine();
            return Operation.getValue(inputOperation);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readOperation();
        }
    }

    public UserSelect readUserSelect() {
        try {
            outputView.printRequire();
            String [] userInput = makeArrayForValidate(Console.readLine());
            Course course = new Course(userInput[0]);
            Level level = new Level(userInput[1]);
            Mission mission  = new Mission(level, userInput[2]);
            return new UserSelect(course, level, mission);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readUserSelect();
        }
    }

    public RematchingIndex readRematching() {
        try {
            outputView.printRematching();
            String rematchIndex = Console.readLine();
            return RematchingIndex.getValue(rematchIndex);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readRematching();
        }
    }

    private String[] makeArrayForValidate(String input) {
        String[] forValidate = input.split(",");
        for (int i = 0; i < forValidate.length; i++) {
            forValidate[i] = forValidate[i].replace(" ", "");
        }
        return forValidate;
    }
}
