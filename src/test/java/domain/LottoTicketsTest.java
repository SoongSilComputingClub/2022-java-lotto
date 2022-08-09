package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @Test
    @DisplayName("로또 티켓 개수 테스트")
    void should_ReturnTotalCount() {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney("14000", "0");
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        Set<LottoTicket> manualTickets = new HashSet<>();
        //when
        LottoTickets lottoTickets = new LottoTickets(lottoPurchaseMoney, manualTickets, lottoNumberGenerator);
        //then
        assertThat(lottoTickets.totalCount()).isEqualTo(14);
    }
}