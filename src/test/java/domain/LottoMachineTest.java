package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoMachineTest {
    @Test
    @DisplayName("티켓 발급 테스트")
    void should_PurchaseTicket() {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney("14000", "1");
        List<String> manualDraws = new ArrayList<>();
        manualDraws.add("1,2,3,4,5,6");
        //when
        LottoMachine lottoMachine = new LottoMachine(lottoPurchaseMoney);
        //then
        assertThatNoException().isThrownBy(() -> lottoMachine.purchase(manualDraws));
        assertThat(lottoMachine.ticketsCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("티켓 발급 테스트 : 모두 자동")
    void should_PurchaseTicket_AllAuto() {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney("14000", "0");
        List<String> manualDraws = new ArrayList<>();
        //when
        LottoMachine lottoMachine = new LottoMachine(lottoPurchaseMoney);
        //then
        assertThatNoException().isThrownBy(() -> lottoMachine.purchase(manualDraws));
        assertThat(lottoMachine.ticketsCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("티켓 발급 테스트 : 모두 수동")
    void should_PurchaseTicket_AllManual() {
        //given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney("3000", "3");
        List<String> manualDraws = new ArrayList<>();
        //when
        LottoMachine lottoMachine = new LottoMachine(lottoPurchaseMoney);
        manualDraws.add("1,2,3,4,5,6");
        manualDraws.add("1,2,3,4,5,6");
        manualDraws.add("1,2,3,4,5,6");
        //then
        assertThatNoException().isThrownBy(() -> lottoMachine.purchase(manualDraws));
        assertThat(lottoMachine.ticketsCount()).isEqualTo(3);
    }
}