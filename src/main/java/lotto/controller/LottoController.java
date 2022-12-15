package lotto.controller;

import lotto.model.BonusNumber;
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
        BonusNumber bonusNumber = enterBonusNumber(lotto);
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

    private BonusNumber enterBonusNumber(Lotto lotto) {
        try {
            return new BonusNumber(inputView.readBonusNumbers(), lotto);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return enterBonusNumber(lotto);
        }
    }
}
