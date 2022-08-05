package Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int lottoCount, LottoNumberGenerator lottoNumberGenerator) {
        this.lottoTickets = new ArrayList<>(lottoCount);
        createLottoTickets(lottoNumberGenerator, lottoCount);
    }

    public int totalCount() {
        return lottoTickets.size();
    }

    public LottoResult findWinner(WinningNumbers winningNumbers) {
        Map<Rank, Integer> winnerMap = new HashMap<>();
        lottoTickets.forEach((lottoTicket) -> {
            Rank rank = winningNumbers.match(lottoTicket);
            winnerMap.put(rank, winnerMap.getOrDefault(rank, 0) + 1);
        });

        return new LottoResult(winnerMap);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        lottoTickets.forEach(lottoTicket -> {
            sb.append(lottoTicket.toString());
            sb.append("\n");
        });

        return sb.toString();
    }

    private void createLottoTickets(LottoNumberGenerator lottoNumberGenerator, int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new LottoTicket(lottoNumberGenerator));
        }
    }
}
