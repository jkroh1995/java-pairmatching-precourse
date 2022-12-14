package pairmatching.domain;

public enum Operation {

    MATCHING("1"),
    SEARCHING("2"),
    INITIALIZING("3"),
    QUIT("Q");

    String operation;

    Operation(String operation){
        this.operation = operation;
    }

    public static Operation getValue(String inputOperation) {
        for(Operation operation : Operation.values()) {
            if(operation.getOperation().equals(inputOperation)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    public String getOperation() {
        return operation;
    }
}
