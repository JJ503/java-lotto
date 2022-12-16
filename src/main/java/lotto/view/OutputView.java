package lotto.view;

import lotto.constants.Rank;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Prizes;

public class OutputView {
    private static final String LOTTO_TICKET_COUNT_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_RESULT_FORMAT = "\n당첨 통계\n---";
    private static final String LOTT_RATE_OF_RETURN = "총 수익률은 %,.1f%%입니다.\n";

    public void printLottoTickets(Lottos lottos) {
        System.out.printf(LOTTO_TICKET_COUNT_FORMAT, lottos.getLottos().size());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }

    public void printLottoResult(Prizes prizes) {
        System.out.println(LOTTO_RESULT_FORMAT);
        for (Rank rank : Rank.values()) {
            printRankResult(prizes, rank);
        }
    }

    private void printRankResult(Prizes prizes, Rank rank) {
        if (rank != Rank.NONE) {
            System.out.println(rank.getRankMessage(prizes.getPrizes(rank)));
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(LOTT_RATE_OF_RETURN, rateOfReturn);
    }
}
