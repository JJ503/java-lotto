package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {
    private static final String LOTTO_TICKET_COUNT_FORMAT = "\n%d개를 구매했습니다.\n";

    public void printLottoTickets(Lottos lottos) {
        System.out.printf(LOTTO_TICKET_COUNT_FORMAT, lottos.getLottos().size());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }
}
