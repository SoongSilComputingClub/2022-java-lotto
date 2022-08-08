package org.sscc.study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningStatTest {

    @Test
    @DisplayName("수익률 계산 테스트")
    public void testPortfolio() {
        WinningStat winningStat = new WinningStat();
        winningStat.add(new MatchData(3, true));
        winningStat.add(new MatchData(3, false));
        winningStat.add(new MatchData(5, true));
        assertThat(winningStat.portfolio(10000)).isEqualTo(3001.00);
    }

    @Test
    @DisplayName("당첨 개수 확인 테스트")
    public void testNumber() {
        WinningStat winningStat = new WinningStat();
        winningStat.add(new MatchData(6, false));
        winningStat.add(new MatchData(3, true));
        winningStat.add(new MatchData(2, true));
        assertThat(winningStat.get(3)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 일치 시 보너스볼 일치에 대해 분리되는 지 확인")
    public void testSecond() {
        WinningStat winningStat = new WinningStat();
        winningStat.add(new MatchData(5, false));
        winningStat.add(new MatchData(5, true));
        assertThat(winningStat.get(5, true)).isEqualTo(1);
    }
}