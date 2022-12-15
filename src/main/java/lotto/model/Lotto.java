package lotto.model;

import lotto.constants.ExceptionMessage;
import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isSix(numbers.size());
        isAllLottoNumber(numbers);
        isDuplicate(numbers);
    }

    private void isSix(int size) {
        if (size != 6) {
            ExceptionMessage.LOTTO_IS_SIX_LOTTO_NUMBER.throwException();
        }
    }

    private void isAllLottoNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            isBetween1And45(number);
        }
    }

    private void isLottoNumber(int number) {
        if (isBetween1And45(number)) {
            ExceptionMessage.LOTTO_NUMBER_BETWEEN_1And45.throwException();
        }
    }

    private boolean isBetween1And45(int number) {
        return LottoConstants.LOTTO_START_NUMBER <= number
                && number <= LottoConstants.LOTTO_END_NUMBER;
    }

    private void isDuplicate(List<Integer> numbers) {
        if (!numbers.equals(toSet(numbers))) {
            ExceptionMessage.LOTTO_NUMBER_NOT_DUPLICATE.throwException();
        }
    }

    private Set toSet(List<Integer> numbers) {
        return new HashSet<>(numbers);
    }
}
