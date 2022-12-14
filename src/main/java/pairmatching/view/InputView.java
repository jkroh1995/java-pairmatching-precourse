package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Operation;

public class InputView {
    
    OutputView outputView = new OutputView();

    public Operation readOperation() {
        try{
            outputView.printOperation();
            String inputOperation = Console.readLine();
            return Operation.getValue(inputOperation);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return readOperation();
        }
    }
}
