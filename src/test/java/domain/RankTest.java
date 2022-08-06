package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    @DisplayName("맞춘 개수에 따른 등수 및 금액 테스트")
    void should_ReturnRank_ForCount() {
        //given

        //when
        int count = 6;
        //then
        assertThat(Rank.of(count)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(count).prize()).isEqualTo(20_0000_0000);
    }
}