package domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LottoTicket {
    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        checkValidation(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public int matching(WinningNumbers winningNumbers) {
        Set<WinningNumber> myNumber = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .map(number -> new WinningNumber(number, BallType.NORMAL))
                .collect(Collectors.toSet());
        myNumber.retainAll(winningNumbers.getWinningNumbers());
        return myNumber.size();
    }

    public boolean matching(WinningNumber bonusNumber) {
        Set<WinningNumber> myNumber = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .map(number -> new WinningNumber(number, BallType.BONUS))
                .collect(Collectors.toSet());
        return myNumber.contains(bonusNumber);
    }

    public String toString() {
        List<String> str = lottoNumbers.stream()
                .sorted()
                .map(LottoNumber::toString)
                .collect(toList());

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(String.join(", ", str));
        sb.append("]");
        return sb.toString();
    }

    private void checkValidation(Set<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        checkUniqueness(lottoNumbers);
    }

    private void checkSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkUniqueness(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
