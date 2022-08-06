package org.sscc.study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryMachineTest {
    @Test
    @DisplayName("가격에 맞는 갯수를 구매했는 지 확인")
    public void testNumber() {
        LotteryMachine lotteryMachine = new LotteryMachine();
        lotteryMachine.pay(14000);
        lotteryMachine.drawNumbers();
        assertThat(lotteryMachine.getNumber()).isEqualTo(14);
    }

    @ParameterizedTest
    @DisplayName("1~45 이외의 값 입력 시 예외 처리 확인")
    @ValueSource(strings = {
            "1, 2, 3, 3, 4, 4",
            "1, 2, 3"
    })
    public void testException(String input) {
        assertThatThrownBy(() -> {
            WinningNumbers winningNumbers = new WinningNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}