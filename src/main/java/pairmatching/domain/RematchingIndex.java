package pairmatching.domain;

public enum RematchingIndex {

    YES("네"),
    NO("아니오");

    private static final String ERROR_REMATCHING_INDEX = "[ERROR] '네' 또는 '아니오'를 입력해주세요.";
    private final String index;

    RematchingIndex(String index) {
        this.index = index;
    }

    public static RematchingIndex getValue(String rematchIndex) {
        for (RematchingIndex rematchingIndex : RematchingIndex.values()) {
            if (rematchingIndex.getIndex().equals(rematchIndex)) {
                return rematchingIndex;
            }
        }
        throw new IllegalArgumentException(ERROR_REMATCHING_INDEX);
    }

    public String getIndex() {
        return index;
    }
}
