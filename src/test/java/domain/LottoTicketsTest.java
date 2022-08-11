package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @Test
    @DisplayName("로또 티켓 개수 테스트")
    void should_ReturnTotalCount() {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney("14000", "1");
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        Set<LottoTicket> manualTickets = new HashSet<>();
        //when
        manualTickets.add(convertManualDrawToLottoTicket("1,2,3,4,5,6"));
        LottoTickets lottoTickets = new LottoTickets(lottoPurchaseMoney, manualTickets, lottoNumberGenerator);
        //then
        assertThat(lottoTickets.totalCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 티켓 개수 테스트 : 모두 자동")
    void should_ReturnTotalCount_AllAuto() {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney("14000", "0");
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        Set<LottoTicket> manualTickets = new HashSet<>();
        //when
        LottoTickets lottoTickets = new LottoTickets(lottoPurchaseMoney, manualTickets, lottoNumberGenerator);
        //then
        assertThat(lottoTickets.totalCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 티켓 개수 테스트 : 모두 수동")
    void should_ReturnTotalCount_AllManual() {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney("1000", "1");
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        Set<LottoTicket> manualTickets = new HashSet<>();
        //when
        manualTickets.add(convertManualDrawToLottoTicket("1,2,3,4,5,6"));
        LottoTickets lottoTickets = new LottoTickets(lottoPurchaseMoney, manualTickets, lottoNumberGenerator);
        //then
        assertThat(lottoTickets.totalCount()).isEqualTo(1);
    }

    private LottoTicket convertManualDrawToLottoTicket(String manualDraw) {
        Set<LottoNumber> manualTicket = Arrays.stream(manualDraw.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        return new LottoTicket(manualTicket);
    }
}