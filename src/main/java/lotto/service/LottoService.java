package lotto.service;

import lotto.model.*;
import lotto.util.RandomLottoNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final

    Lottos lottos = new Lottos();
    Prizes prizes = new Prizes();

    public LottoService(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> randomLotto =
                    new ArrayList<>(new RandomLottoNumbersGenerator().generate());
            lottos.addLotto(new Lotto(randomLotto));
        }
    }

    public Lottos getLottos() {
        return lottos;
    }

    public void calculateLotto(Lotto winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            prizes.addPrize(new Prize(lotto, winningNumbers, bonusNumber));
        }
    }

    public Prizes getResult() {
        return prizes;
    }

    public double getRateOfReturn(float purchaseAmount) {
        return roundSecondDigit(prizes.getTotalPrizeMoney() / purchaseAmount * 100);
    }

    public double roundSecondDigit(double value) {
        return Math.round(value * 10) / 10.0;
    }
}
