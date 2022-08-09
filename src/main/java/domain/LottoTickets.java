package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTickets {
    private final Set<LottoTicket> lottoTickets;

    public LottoTickets(LottoPurchaseMoney lottoPurchaseMoney, Set<LottoTicket> manualTickets, LottoNumberGenerator lottoNumberGenerator) {
        this.lottoTickets = new HashSet<>(manualTickets);
        createAutoLottoTickets(lottoNumberGenerator, lottoPurchaseMoney.getAutoDrawAmount());
    }

    public int totalCount() {
        return lottoTickets.size();
    }

    public List<Rank> findWinner(WinningNumbers winningNumbers) {
        List<Rank> winnerList = new ArrayList<>();
        lottoTickets.forEach((lottoTicket) -> {
            Rank rank = winningNumbers.getRank(lottoTicket);
            winnerList.add(rank);
        });

        return winnerList;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        lottoTickets.forEach(lottoTicket -> {
            sb.append(lottoTicket.toString());
            sb.append("\n");
        });

        return sb.toString();
    }

    private void createAutoLottoTickets(LottoNumberGenerator lottoNumberGenerator, int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new LottoTicket(lottoNumberGenerator.newLottoNumber()));
        }
    }
}
