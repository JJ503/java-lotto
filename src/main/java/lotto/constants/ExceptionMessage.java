package lotto.constants;

public enum ExceptionMessage {
    NONE_INPUT("값을 입력해 주셔야 합니다."),
    NOT_INPUT_NUMBER("숫자를 입력해 주셔야 합니다."),
    INPUT_MORE_THAN_ZERO("0을 초과한 값을 입력해 주셔야 합니다."),
    INPUT_AMOUNT_UNITY("천 단위의 숫자를 입력해 주셔야 합니다."),
    LOTTO_IS_SIX_LOTTO_NUMBER("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_BETWEEN_1And45("로또 번호는 1 ~ 45 사이 값이어야 합니다."),
    LOTTO_NUMBER_NOT_DUPLICATE("로또 번호는 중복되는 값이 없어야 합니다."),
    BONUS_NUMBER_NOT_DUPLICATE_WINNING_NUMBERS("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage + System.lineSeparator();
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
