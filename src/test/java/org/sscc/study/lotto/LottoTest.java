package org.sscc.study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("가격에 맞는 갯수를 구매했는 지 확인")
    public void testNumber() {
        Lottery lottery = new Lottery();
        lottery.pay(14000);
        lottery.drawNumbers(new RandomLottoNumber());
        Record record = lottery.getTickets();
        assertThat(record.getNumber()).isEqualTo(14);
    }

    @Test
    @DisplayName("당첨번호 입력 시 번호가 일치하는 지 확인")
    public void testWinningNumber() {
        Lottery lottery = new Lottery();
        lottery.pay(3000);
        lottery.drawNumbers(new StaticLottoNumber());
        Record record = lottery.getTickets();
        List<Integer> duplicates = record.duplicateNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(duplicates).isEqualTo(Arrays.asList(6, 6, 6));
    }

    @Test
    @DisplayName("수익률이 올바른 지 확인")
    public void testPortfolio() {
        Lottery lottery = new Lottery();
        lottery.pay(5000);
        lottery.drawNumbers(new StaticLottoNumber());
        Record record = lottery.getTickets();

        Winning winning = new Winning("1, 2, 3, 7, 8, 9");
        WinningStat winningStat = winning.getStat(record);
        assertThat(winningStat.portfolio(5000)).isEqualTo(5);
    }
}