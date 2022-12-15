package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoService lottoService;

    public void startLottoGame() {
        PurchaseAmount purchaseAmount = enterPurchaseAmount();
        lottoService = new LottoService(purchaseAmount.getLottoTickets());
        outputView.printLottoTickets(lottoService.getLottos());
        Lotto lotto = enterWinningLotto();
    }

    private PurchaseAmount enterPurchaseAmount() {
        try {
            return new PurchaseAmount(inputView.readPurchaseAmount());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return enterPurchaseAmount();
        }
    }

    private Lotto enterWinningLotto() {
        try {
            return new Lotto(inputView.readWinningNumbers());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return enterWinningLotto();
        }
    }
}
