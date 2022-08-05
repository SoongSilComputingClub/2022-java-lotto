package View;

import Domain.LottoResult;
import Domain.Rank;

import java.text.DecimalFormat;
import java.util.Map;

import static Domain.Rank.*;

public class ResultView {
    public void printTotalCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoTickets(String lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void printWinnerStat(Map<Rank, Integer> lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + FOURTH.prize() + "원)-" + lottoResult.getOrDefault(FOURTH, 0) + "개");
        System.out.println("4개 일치 (" + THIRD.prize() + "원)-" + lottoResult.getOrDefault(THIRD, 0) + "개");
        System.out.println("5개 일치 (" + SECOND.prize() + "원)-" + lottoResult.getOrDefault(SECOND, 0) + "개");
        System.out.println("6개 일치 (" + FIRST.prize() + "원)-" + lottoResult.getOrDefault(FIRST, 0) + "개");
    }

    public void printEarningRatio(double rate) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print("총 수익률은 " + df.format(rate) + "입니다.");
    }
}
