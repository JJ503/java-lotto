package lotto.model;

import lotto.constants.ExceptionMessage;
import lotto.constants.LottoConstants;

public class PurchaseAmount {
    private final int purchaseAmount;

    PurchaseAmount(int purchaseAmount) {
        validateAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateAmount(int checkValue) {
        isZero(checkValue);
        isAmountUnity(checkValue);
    }

    private static void isZero(Integer inputValue) {
        if (inputValue == LottoConstants.ZERO) {
            ExceptionMessage.INPUT_MORE_THAN_ZERO.throwException();
        }
    }

    private static void isAmountUnity(Integer inputValue) {
        if (inputValue / LottoConstants.AMOUNT_UNIT != LottoConstants.ZERO) {
            ExceptionMessage.INPUT_AMOUNT_UNITY.throwException();
        }
    }
}
