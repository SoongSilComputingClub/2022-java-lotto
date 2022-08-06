package org.sscc.study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LotteryTicketsTest {
    @Test
    @DisplayName("당첨번호 입력 시 번호가 일치하는 지 확인")
    public void testWinning() {
        LotteryTickets lotteryTickets = new LotteryTickets();
        lotteryTickets.addLotteryTicket(new StaticLottoNumberGenerator());
        List<Integer> duplicate = lotteryTickets.duplicateNumbers(
                new WinningNumbers("1, 2, 3, 4, 5, 6").getWinningNumbers());
        assertThat(duplicate).isEqualTo(List.of(6));
    }

    @Test
    @DisplayName("로또 번호가 문자열 형식에 맞게 출력되는 지 확인")
    public void testNumberString() {
        LotteryTickets lotteryTickets = new LotteryTickets();
        lotteryTickets.addLotteryTicket(new StaticLottoNumberGenerator());
        String result = lotteryTickets.getString();
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}