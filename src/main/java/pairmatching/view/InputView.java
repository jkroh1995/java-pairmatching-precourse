package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.OperationIndex;
import pairmatching.domain.RematchingIndex;
import pairmatching.domain.mission.UserSelect;

public class InputView {

    OutputView outputView = new OutputView();

    public OperationIndex readOperation() {
        try {
            outputView.printOperation();
            String inputOperation = Console.readLine();
            return OperationIndex.getValue(inputOperation);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readOperation();
        }
    }

    public UserSelect readUserSelect() {
        try {
            outputView.printRequire();
            String input = Console.readLine();
            return new UserSelect(makeArrayForValidate(input));
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
