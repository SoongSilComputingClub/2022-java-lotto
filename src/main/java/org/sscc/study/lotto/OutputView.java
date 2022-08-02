package org.sscc.study.lotto;

public class OutputView {

    public void printLottoNumbers(Record record) {
        System.out.println(record.getNumber() + "개를 구매했습니다.");
        for (int i = 0; i < record.getNumber(); i++) {
            System.out.println("[" + record.NumbersToString(i) + "]");
        }
    }

    public void printStat(WinningStat winningStat) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, Prize.getPrize(i), winningStat.get(i));
        }
    }

    public void printPortfolio(WinningStat winningStat, int price) {
        System.out.printf("총 수익률은 %.2f입니다.", (double) winningStat.totalPrize() / price);
    }
}
