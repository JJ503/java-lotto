package lotto.validation;

import lotto.constants.ExceptionMessage;
import lotto.constants.LottoConstants;

public class InputValidation {

    public static Integer validateAmount(String amount) {
        isExist(amount);
        Integer amountNumber = toNumber(amount);
        isZero(amountNumber);
        isAmountUnity(amountNumber);
        return amountNumber;
    }

    private static void isExist(String inputValue) {
        if (inputValue.isEmpty()) {
            ExceptionMessage.NONE_INPUT.throwException();
        }
    }

    private static Integer toNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException numberFormatException) {
            ExceptionMessage.NOT_INPUT_NUMBER.throwException();
        }

        return null;
    }

    private static void isZero(Integer inputValue) {
        if (inputValue == LottoConstants.ZERO) {
            ExceptionMessage.INPUT_MORE_THAN_ZERO.throwException();
        }
    }

    private static void isAmountUnity(Integer inputValue) {
        if (inputValue % LottoConstants.AMOUNT_UNIT != LottoConstants.ZERO) {
            ExceptionMessage.INPUT_AMOUNT_UNITY.throwException();
        }
    }
}
