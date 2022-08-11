package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class LottoTicket {
    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        checkValidation(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
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
        checkRedundancy(lottoNumbers);
    }

    private void checkSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개입니다.");
        }
    }

    private void checkRedundancy(Set<LottoNumber> lottoNumbers) {
        Set<LottoNumber> SetOfNumbers = new HashSet<>(lottoNumbers);
        if (SetOfNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
