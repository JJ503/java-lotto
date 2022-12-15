package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoService lottoService = new LottoService();

    public void startLottoGame() {
        PurchaseAmount purchaseAmount = enterPurchaseAmount();
    }

    private PurchaseAmount enterPurchaseAmount() {
        try {
            return new PurchaseAmount(inputView.readPurchaseAmount());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return enterPurchaseAmount();
        }
    }
}
