package kr.eddi.demo.utility.basic.seventh;

import kr.eddi.demo.entity.basic.seventh.Player;
import kr.eddi.demo.utility.basic.third.CustomRandom;

import java.util.List;

// 인터페이스는 상속하지 않고 구현한다고 한다.
// 왜냐하면 매서드가 작성되어 있지 않기 때문에
// implements 하는 클래스에서 매서드를 구현해줘야 한다.
public class Dice implements SpecialDiceOption {
    private static final int MIN = 1;
    private static final int MAX = 6;

    public static int rollDice() {
        return CustomRandom.makeIntCustomRandom(MIN, MAX);
    }

    public static void steelPlayerScore(List<Player> players, int playerIdx, int steelScore) {
        for (int i = 0; i < players.size(); i++) {
            if (i == playerIdx) { continue; }

            players.get(i).getScore().addScore(-steelScore);
            players.get(playerIdx).getScore().addScore(steelScore);
        }
    }

    public static void donatePlayerScore(List<Player> players, int playerIdx, int donateScore) {
        for (int i = 0; i < players.size(); i++) {
            if (i == playerIdx) { continue; }

            players.get(playerIdx).getScore().addScore(-donateScore);
            players.get(i).getScore().addScore(donateScore);
        }
    }
    // rollSpecialDice는 플레이어 객체 정보가 필요함
    // 나를 제외하고 적용하는 경우도 존재하니까
    @Override
    public void checkSpecialDice(List<Player> players, int diceNum, int playerIdx) {
        final int SOB = 1;
        final int LUCKY = 3;
        final int DEATH = 4;
        final int BULLSHIT = 5;

        final int SOB_SCORE = 2;
        final int LUCKY_SCORE = 3;
        final int DEATH_SCORE = -4444;
        final int BULLSHIT_SCORE = 2;

        for (int i = 0; i < players.size(); i++) {
            switch (diceNum) {
                case SOB:
                    players.get(i).getScore().addScore(-SOB_SCORE);
                    break;

                case LUCKY:
                    // 플레이어에 구현하는 것이 좋을까 ?
                    // 점수에 구현하는 것이 좋을까 ?
                    // 아니면 별개로 구현하는 것이 좋을까 ?
                    steelPlayerScore(players, playerIdx, LUCKY_SCORE);
                    break;

                case DEATH:
                    players.get(i).getScore().setTotalScore(DEATH_SCORE);
                    break;

                case BULLSHIT:
                    donatePlayerScore(players, playerIdx, BULLSHIT_SCORE);
                    break;
            }
        }
    }
}
