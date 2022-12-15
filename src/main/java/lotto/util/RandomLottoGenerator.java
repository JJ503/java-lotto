package lotto.util;

import java.util.List;

@FunctionalInterface
public interface RandomLottoGenerator {
    List<Integer> generate();
}
