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

    public void gameStart(Player players[]) {
        for (int i = 0; i < players.length; i++) {
            int diceNum = Dice.rollDice();
            score.addScore(diceNum);

            if (diceNum % 2 == 0) {
                diceNum = Dice.rollDice();
                Dice specialDice = new Dice();
                score.addScore(diceNum);

                specialDice.checkSpecialDice(players, diceNum, i);
            }
        }
    }
}
