package kr.eddi.demo.entity.basic.nineth;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LottoCardManager {
    private List<LottoCard> cards;
    private final int LOTTO_CARD_LENGTH = 6;
    private final int DUPLICATE_LIMITATION = 100;

    public LottoCardManager(int playerNum) {
        cards = new ArrayList<>(playerNum);

        for (int i = 0; i < playerNum; i++) {
            cards.add(new LottoCard());
        }
    }

    public void allocLottoCardNumber() {
        int tmpNum;
        int people = cards.size();

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {
            for (int i = 0; i < people; i++) {
                if (people > DUPLICATE_LIMITATION) { cards.get(i).generateLottoNumber(j); }
                else {
                    do {
                        tmpNum = cards.get(i).generateLottoNumber(j);
                    } while (verifyDuplicateLottoCard(i, j, cards));
                }
            }
        }
    }

    public void allocNonDuplicateLottoCardNumber() {
        int tmpNum;

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {
            for (int i = 0; i < cards.size(); i++) {
                do {
                    tmpNum = cards.get(i).generateLottoNumber(j);
                } while (verifyDuplicateLottoCard(i, j, cards));
            }
        }
    }

    private Boolean verifyDuplicateLottoCard(
            int curPersonIdx, int curLottoColumnIdx, List<LottoCard> cards) {

        if (curPersonIdx == 0) { return false; }

        int compareTarget = cards.get(curPersonIdx).getNumbers()[curLottoColumnIdx];

        for (int i = 0; i < curPersonIdx; i++) {
            int eachNumber = cards.get(i).getNumbers()[curLottoColumnIdx];

            System.out.printf("curPersonIdx: %d, compareTarget: %d, eachNumber: %d\n",
                    curPersonIdx, compareTarget, eachNumber);

            if (eachNumber == compareTarget) {
                return true;
            }
        }

        return false;
    }

    public void allocDuplicateLottoCardNumber() {
        int tmpNum;

        for (int j = 0; j < LOTTO_CARD_LENGTH; j++) {
            for (int i = 0; i < cards.size(); i++) {
                cards.get(i).generateLottoNumber(j);
            }
        }
    }
}
