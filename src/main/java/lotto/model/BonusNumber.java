package lotto.model;

import lotto.constants.ExceptionMessage;
import lotto.constants.LottoConstants;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto lotto) {
        validate(bonusNumber, lotto);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int number, Lotto lotto) {
        isLottoNumber(number);
        isNotDuplicateNumbers(number, lotto);
    }

    private void isLottoNumber(int number) {
        if (!isBetween1And45(number)) {
            ExceptionMessage.LOTTO_NUMBER_BETWEEN_1And45.throwException();
        }
    }

    private boolean isBetween1And45(int number) {
        return LottoConstants.LOTTO_START_NUMBER <= number
                && number <= LottoConstants.LOTTO_END_NUMBER;
    }

    private void isNotDuplicateNumbers(int number, Lotto lotto) {
        if (lotto.isMatchNumber(number)) {
            ExceptionMessage.BONUS_NUMBER_NOT_DUPLICATE_WINNING_NUMBERS.throwException();
        }
    }
}
