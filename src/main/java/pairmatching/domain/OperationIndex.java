package pairmatching.domain;

public enum OperationIndex {

    MATCHING("1"),
    SEARCHING("2"),
    INITIALIZING("3"),
    QUIT("Q");

    private static final String ERROR_OPERATION = "[ERROR] 존재하지 않는 기능 번호입니다.";
    private final String operation;

    OperationIndex(String operation) {
        this.operation = operation;
    }

    public static OperationIndex getValue(String inputOperation) {
        for (OperationIndex operation : OperationIndex.values()) {
            if (operation.getOperation().equals(inputOperation)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(ERROR_OPERATION);
    }

    public String getOperation() {
        return operation;
    }
}
