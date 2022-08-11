package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {
    private final LottoNumberGenerator generator;
    private final LottoPurchaseMoney lottoPurchaseMoney;
    private LottoTickets lottoTickets;

    public LottoMachine(LottoPurchaseMoney lottoPurchaseMoney) {
        this.generator = new LottoNumberGenerator();
        this.lottoPurchaseMoney = lottoPurchaseMoney;
    }

    public void purchase(List<String> manualDraws) {
        Set<LottoTicket> manualTickets = convertManualDrawsToLottoTickets(manualDraws);
        lottoTickets = new LottoTickets(lottoPurchaseMoney, manualTickets, generator);
    }

    public LottoResult confirm(WinningNumbers winningNumbers) {
        return new LottoResult(lottoTickets.findWinner(winningNumbers), lottoPurchaseMoney.getInvestMoney());
    }

    public String ticketsToString() {
        return lottoTickets.toString();
    }

    public int ticketsCount() {
        return lottoTickets.totalCount();
    }

    private Set<LottoTicket> convertManualDrawsToLottoTickets(List<String> manualDrawList) {
        Set<LottoTicket> manualTickets = new HashSet<>();

        if (manualDrawList.isEmpty()) {
            return manualTickets;
        }

        manualDrawList.forEach(manualDraw -> manualTickets.add(convertManualDrawToLottoTicket(manualDraw)));
        return manualTickets;
    }

    private LottoTicket convertManualDrawToLottoTicket(String manualDraw) {
        Set<LottoNumber> manualTicket = Arrays.stream(manualDraw.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        return new LottoTicket(manualTicket);
    }
}
