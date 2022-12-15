package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.List;

public class RandomLottoNumbersGenerator implements RandomLottoGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_START_NUMBER,
                LottoConstants.LOTTO_END_NUMBER, LottoConstants.LOTTO_COUNT);
    }
}
