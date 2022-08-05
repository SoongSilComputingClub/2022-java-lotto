package Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoMachineTest {
    @Test
    @DisplayName("티켓 발급 테스트")
    void should_PurchaseTicket() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        //when
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney(14000);
        //then
        assertThatNoException().isThrownBy(() -> lottoMachine.purchase(lottoPurchaseMoney));
        assertThat(lottoMachine.ticketsCount()).isEqualTo(14);
    }
}