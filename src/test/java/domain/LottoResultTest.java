package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LottoResultTest {
    @Test
    @DisplayName("수익률 계산 테스트")
    void should_ReturnPERatio() {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney(14000);
        Map<Rank, Integer> winnerMap = new HashMap<>();
        winnerMap.put(Rank.FOURTH, 1);
        //when
        LottoResult lottoResult = new LottoResult(winnerMap);
        //then
        assertThat(lottoResult.earningRate(lottoPurchaseMoney)).isEqualTo(0.35, offset(0.01d));
    }
}