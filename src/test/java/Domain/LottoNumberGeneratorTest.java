package Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumberGeneratorTest {
    @Test
    @DisplayName("로또 번호 생성 테스트")
    void should_GenerateLottoNumber() {
        //given
        LottoNumberGenerator generator = new LottoNumberGenerator();
        //when
        List<Integer> lottoNumber = generator.newLottoNumber();
        //then
        assertThatNoException().isThrownBy(generator::newLottoNumber);
        assertThat(generator.newLottoNumber()).isInstanceOf(ArrayList.class);
        assertThat(lottoNumber).isNotEmpty()
                .hasSize(6)
                .doesNotHaveDuplicates();
    }
}