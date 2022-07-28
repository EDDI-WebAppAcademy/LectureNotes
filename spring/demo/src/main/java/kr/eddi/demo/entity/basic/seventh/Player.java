package kr.eddi.demo.entity.basic.seventh;

import kr.eddi.demo.utility.basic.seventh.Dice;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Player implements Comparable<Player> {
    private Score score;
    private String nickName;

    private final String DEFAULT = "anonymous";

    public Player() {
        nickName = DEFAULT;
        score = new Score();
    }

    public void gameStart(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
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

    // 코드 단위로 분석하면 대가리 폭발하므로
    // 쉽게 생각한다면 아래와 같은 메커니즘으로 보도록 한다.
    // 1. 내가 비교하고자 하는 정보가 무엇인가 ? 현재 우리케이스는 totalScore
    //    그래서 비교 대상에 this.getScore().getTotalScore(),
    //    player.getScore().getTotalScore()이 사용됨
    // 2. 다음으로 한쪽이 크면 양수, 작으면 음수, 같으면 0으로 배치하면
    //    내가 비교하고자 하는 값으로 언제든지 정렬이됨
    // 3. 내부 코드 볼 필요 없음 (추상화)
    @Override
    public int compareTo(Player player) {
        int srcScore = this.getScore().getTotalScore();
        int dstScore = player.getScore().getTotalScore();

        if (srcScore > dstScore) {
            return 1;
        } else if (srcScore < dstScore) {
            return -1;
        } else {
            return 0;
        }
    }
}
