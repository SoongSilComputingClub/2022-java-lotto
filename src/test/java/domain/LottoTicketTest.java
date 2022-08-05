package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoTicketTest {
    @Test
    @DisplayName("로또 티켓 생성 테스트")
    void should_GenerateTicket() {
        assertThatNoException().isThrownBy(() -> new LottoTicket(new LottoNumberGenerator().newLottoNumber()));
    }
}