package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LottoResultTest {
    @Test
    @DisplayName("수익률 계산 테스트")
    void should_ReturnPERatio() {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney("14000", "0");
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIFTH);
        //when
        LottoResult lottoResult = new LottoResult(ranks, lottoPurchaseMoney.getInvestMoney());
        //then
        assertThat(lottoResult.earningRate()).isEqualTo(0.35, offset(0.01d));
    }
}