package pairmatching.domain;

public enum Operation {

    MATCHING("1", ". 페어 매칭"),
    SEARCHING("2", ". 페어 조회"),
    INITIALIZING("3", ". 페어 초기화"),
    QUIT("Q", ". 종료");

    private static final String ERROR_OPERATION = "[ERROR] 존재하지 않는 기능 번호입니다.";
    private final String operationIndex;
    private final String operation;

    Operation(String operationIndex, String operation) {
        this.operationIndex = operationIndex;
        this.operation = operation;
    }

    public static Operation getValue(String inputOperation) {
        for (Operation operation : Operation.values()) {
            if (operation.getOperationIndex().equals(inputOperation)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(ERROR_OPERATION);
    }

    public String getOperationIndex() {
        return operationIndex;
    }

    public String getOperation() {
        return operation;
    }
}
