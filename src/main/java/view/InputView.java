package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    private String manualDrawAmount;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public String getManualDrawAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        manualDrawAmount = scanner.nextLine();
        return manualDrawAmount;
    }

    public List<String> getManualDraws() {
        int manualDrawAmount = Integer.parseInt(this.manualDrawAmount);
        List<String> inputs = new ArrayList<>();

        if (manualDrawAmount <= 0) {
            return inputs;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        while (manualDrawAmount-- > 0) {
            inputs.add(scanner.nextLine());
        }
        return inputs;
    }

    public String getWinner() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
