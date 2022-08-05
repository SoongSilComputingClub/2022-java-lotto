package Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    @Test
    @DisplayName("로또 티켓 생성 테스트")
    void should_GenerateTicket() {
        assertThatNoException().isThrownBy(() -> new LottoTicket(new LottoNumberGenerator()));
    }

    @Test
    @DisplayName("로또 티켓 불변 테스트")
    void should_ThrowException_AsImmutableList() {
        //given
        LottoTicket lottoTicket = new LottoTicket(new LottoNumberGenerator());
        //when
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();
        //then
        assertThatThrownBy(() -> lottoNumbers.add(3)).isInstanceOf(UnsupportedOperationException.class);
    }
}