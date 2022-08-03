package org.sscc.study.lotto;

public class OutputView {
    private static final int MINIMUM = 3;
    private static final int MAXIMUM = 6;

    public void printLottoNumbers(Record record) {
        System.out.println(record.getNumber() + "개를 구매했습니다.");
        for (int i = 0; i < record.getNumber(); i++) {
            System.out.println("[" + record.numbersToString(i) + "]");
        }
    }

    public void printStat(WinningStat winningStat) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = MINIMUM; i <= MAXIMUM; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, Prize.getPrize(i), winningStat.get(i));
        }
    }

    public void printPortfolio(double portfolio) {
        System.out.printf("총 수익률은 %.2f입니다.", portfolio);
    }
}
