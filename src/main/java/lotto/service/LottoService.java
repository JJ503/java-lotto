package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.RandomLottoNumbersGenerator;

public class LottoService {
    private static final

    Lottos lottos = new Lottos();

    public LottoService(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            lottos.addLotto(new Lotto(new RandomLottoNumbersGenerator().generate()));
        }
    }

    public Lottos getLottos() {
        return lottos;
    }
}
