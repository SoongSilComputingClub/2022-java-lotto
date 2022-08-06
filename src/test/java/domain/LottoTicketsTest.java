package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @Test
    @DisplayName("로또 티켓 개수 테스트")
    void should_ReturnTotalCount() {
        //given
        int lottoCount = 14;
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        //when
        LottoTickets lottoTickets = new LottoTickets(lottoCount, lottoNumberGenerator);
        //then
        assertThat(lottoTickets.totalCount()).isEqualTo(14);
    }
}