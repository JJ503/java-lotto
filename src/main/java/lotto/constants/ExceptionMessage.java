package lotto.constants;

public enum ExceptionMessage {
    NONE_INPUT("값을 입력해 주셔야 합니다."),
    NOT_INPUT_NUMBER("숫자를 입력해 주셔야 합니다."),
    INPUT_MORE_THAN_ZERO("0을 초과한 값을 입력해 주셔야 합니다."),
    INPUT_AMOUNT_UNITY("천 단위의 숫자를 입력해 주셔야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
