package kr.eddi.demo.utility.basic.sixth.clean.company1;

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

    // rollSpecialDice는 플레이어 객체 정보가 필요함
    // 나를 제외하고 적용하는 경우도 존재하니까
    @Override
    public void checkSpecialDice(Player player[], int diceNum, int playerIdx) {
        final int SOB = 1;
        final int LUCKY = 3;
        final int DEATH = 4;
        final int BULLSHIT = 5;

        final int SOB_SCORE = -2;
        final int LUCKY_SCORE = 3;
        final int DEATH_SCORE = -4444;
        final int BULLSHIT_SCORE = 2;

        for (int i = 0; i < player.length; i++) {
            switch (diceNum) {
                case SOB:
                    //player[i].applyScore();
                    break;

                case LUCKY:
                    break;

                case DEATH:
                    break;

                case BULLSHIT:
                    break;
            }
        }
    }
}
