package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            0,
            46,
            101
    })
    @DisplayName("로또 번호 범위 테스트")
    void should_ThrowException_ForLottoNumberOutOfRange(int number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }
}