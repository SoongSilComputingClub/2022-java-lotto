package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> newLottoNumber() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numList.add(i);
        }

        List<Integer> lottoNumber;
        Collections.shuffle(numList);
        lottoNumber = numList.subList(0, 6);
        Collections.sort(lottoNumber);

        return new ArrayList<>(lottoNumber);
    }
}
