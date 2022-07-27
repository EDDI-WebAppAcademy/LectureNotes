package kr.eddi.demo.utility.basic.sixth.clean.company2;

import kr.eddi.demo.entity.basic.sixth.clean.Player;
import kr.eddi.demo.utility.basic.sixth.clean.SpecialDiceOption;
import kr.eddi.demo.utility.basic.third.CustomRandom;

// 인터페이스는 상속하지 않고 구현한다고 한다.
// 왜냐하면 매서드가 작성되어 있지 않기 때문에
// implements 하는 클래스에서 매서드를 구현해줘야 한다.
public class Dice implements SpecialDiceOption {
    private static final int MIN = 1;
    private static final int MAX = 6;

    public static int rollDice() {
        return CustomRandom.makeIntCustomRandom(MIN, MAX);
    }

    @Override
    public void checkSpecialDice(Player player[], int diceNum, int playerIdx) {

    }
}
