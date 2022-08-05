package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, 6, 7",
            "1, 1, 3, 4, 5, 6"
    })
    @DisplayName("문자열 입력 유효성 테스트")
    void should_ThrowException_ForInvalidString(String input) {
        assertThatThrownBy(() -> new WinningNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 티켓 불변 테스트")
    void should_ThrowException_AsImmutableList() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        //when
        List<Integer> unmodifiableNumbers = winningNumbers.getWinningNumbers();
        //then
        assertThatThrownBy(() -> unmodifiableNumbers.add(3)).isInstanceOf(UnsupportedOperationException.class);
    }
}