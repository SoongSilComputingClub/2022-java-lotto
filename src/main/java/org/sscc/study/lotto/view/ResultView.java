package org.sscc.study.lotto.view;

import org.sscc.study.lotto.domain.Prize;
import org.sscc.study.lotto.domain.WinningStat;

public class ResultView {
    public void printNumber(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public void printLottoNumbers(String result) {
        System.out.println(result);
    }

    public void printStat(WinningStat winningStat) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (%d원)- %d개\n", Prize.FIFTH.getPrize(), winningStat.get(Prize.FIFTH));
        System.out.printf("4개 일치 (%d원)- %d개\n", Prize.FOURTH.getPrize(), winningStat.get(Prize.FOURTH));
        System.out.printf("5개 일치 (%d원)- %d개\n", Prize.THIRD.getPrize(), winningStat.get(Prize.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치(%d원) - %d개\n",
                Prize.SECOND.getPrize(), winningStat.get(Prize.SECOND));
        System.out.printf("6개 일치 (%d개) - %d개\n", Prize.FIRST.getPrize(), winningStat.get(Prize.FIRST));
    }

    public void printPortfolio(double portfolio) {
        System.out.printf("총 수익률은 %.2f입니다.\n", portfolio);
    }
}
