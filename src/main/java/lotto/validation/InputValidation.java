package lotto.validation;

import lotto.constants.ExceptionMessage;
import lotto.constants.LottoConstants;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidation {
    private static final String COMMA = ",";

    public static Integer validateAmount(String amount) {
        isExist(amount);
        Integer amountNumber = toNumber(amount);
        isZero(amountNumber);
        isAmountUnity(amountNumber);
        return amountNumber;
    }

    public static List<Integer> validateWinningNumbers(String numbers) {
        isExist(numbers);
        List<Integer> winningNumbers = toIntegerList(numbers);
        isSix(winningNumbers.size());

        return winningNumbers;
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

    private static List<Integer> toIntegerList(String inputValue) {
        try {
            return toList(inputValue).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            ExceptionMessage.NOT_INPUT_NUMBER.throwException();
        }

        return null;
    }

    private static List<String> toList(String inputValue) {
        return List.of(inputValue.split(COMMA));
    }

    private static void isSix(int size) {
        if (size != LottoConstants.LOTTO_COUNT) {
            ExceptionMessage.LOTTO_IS_SIX_LOTTO_NUMBER.throwException();
        }
    }
}
