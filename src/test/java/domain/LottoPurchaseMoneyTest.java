package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseMoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {
            -500,
            0,
            500
    })
    @DisplayName("로또 구입 금액 테스트")
    void should_ReturnMaxCount(int money) {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney(14000);
        //when

        //then
        assertThatNoException().isThrownBy(() -> new LottoPurchaseMoney(14000));
        assertThatThrownBy(() -> new LottoPurchaseMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(lottoPurchaseMoney.getAmount()).isEqualTo(14);
    }
}