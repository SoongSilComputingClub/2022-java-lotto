package org.sscc.study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        Winning winning = new Winning("1, 2, 3, 4, 5, 6");
        WinningStat winningStat = winning.getStat(record);
        assertThat(winningStat.get(6)).isEqualTo(3);
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

    @Test
    @DisplayName("로또 번호가 문자열 형식에 맞게 출력되는 지 확인")
    public void testNumberString() {
        Lottery lottery = new Lottery();
        lottery.pay(1000);
        lottery.drawNumbers(new StaticLottoNumber());
        Record record = lottery.getTickets();
        assertThat(record.numbersToString(0)).isEqualTo("1, 2, 3, 4, 5, 6");
    }
}