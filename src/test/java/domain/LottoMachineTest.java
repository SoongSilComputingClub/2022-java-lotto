package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoMachineTest {
    @Test
    @DisplayName("티켓 발급 테스트")
    void should_PurchaseTicket() {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney("14000");
        //when
        LottoMachine lottoMachine = new LottoMachine(lottoPurchaseMoney);
        //then
        assertThatNoException().isThrownBy(lottoMachine::purchase);
        assertThat(lottoMachine.ticketsCount()).isEqualTo(14);
    }
}