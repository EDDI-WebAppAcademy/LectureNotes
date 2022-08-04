package kr.eddi.demo.entity.basic.sixth.clean;

import kr.eddi.demo.utility.basic.sixth.clean.company1.Dice;
import lombok.Getter;

@Getter
public class Player {
    private Score score;
    private String nickName;

    private final String DEFAULT = "anonymous";

    public Player() {
        nickName = DEFAULT;
        score = new Score();
    }

    // 이와 같이 Player를 players로 활용하게 되면 가독성이 떨어지고
    // 코드 자체의 혼동을 유발하게 됨 (더티)
    public void gameStart(Player players[]) {
        int diceNum = Dice.rollDice();
        score.addScore(diceNum);

        // 매우 더티함 ...
        // 추후 리팩토링 필요
        if (diceNum % 2 == 0) {
            Dice specialDice = new Dice();
            diceNum = Dice.rollDice();
            score.addScore(diceNum);

            for (int i = 0; i < players.length; i++) {
                specialDice.checkSpecialDice(players, diceNum, i);
            }
        }
    }
}
