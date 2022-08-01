package kr.eddi.demo.entity.basic.nineth;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LottoCard {
    private int[] numbers;

    private final int LOTTO_NUMBER_LENGTH = 6;
    private final int BIAS = 1;
    private final int MIN = 0;
    private final int MAX = 99 + BIAS;

    public LottoCard() {
        numbers = new int[LOTTO_NUMBER_LENGTH];
    }

    public int generateLottoNumber(int curIdx) {
        int tmpNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
        numbers[curIdx] = tmpNum;

        return tmpNum;
    }
}
