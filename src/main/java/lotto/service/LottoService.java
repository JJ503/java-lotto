package lotto.service;

import lotto.model.*;
import lotto.util.RandomLottoNumbersGenerator;

public class LottoService {
    private static final

    Lottos lottos = new Lottos();
    Prizes prizes = new Prizes();

    public LottoService(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            lottos.addLotto(new Lotto(new RandomLottoNumbersGenerator().generate()));
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
}
