package kr.eddi.demo.entity.basic.nineth;

import kr.eddi.demo.utility.basic.nineth.Score;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
public class WinnerManager {
    private Map<Player, Integer> winnerScoreMap;

    public WinnerManager() {
        winnerScoreMap = new HashMap<>();
    }

    public List sortWinner(List<Player> players) {
        Score.calcPlayersScore(players);

        for (int i = 0; i < players.size(); i++) {
            winnerScoreMap.put(players.get(i), Score.getScore(i));
        }

        List<Map.Entry<Player, Integer>> winner = winnerScoreMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        System.out.println(winner);

        return winner;
    }

    public void doReward(List winner) {
        Map.Entry<Player, Integer> first = (Map.Entry<Player, Integer>) winner.get(winner.size() - 1);
        int top = first.getValue();
        int cnt = 0;

        for (int i = winner.size() - 2; i >= 0; i--) {
            if (top == ((Map.Entry<Player, Integer>) winner.get(i)).getValue()) {
                cnt++;
            }
            else {
                System.out.println("단일 우승 - 승자명: " + first.getKey().getNickName());
                return;
            }
        }

        BigInteger reward = new BigInteger("10000000000");
        reward.divide(BigInteger.valueOf(cnt)).toString();

        System.out.println("reward: " + reward);

        for (int i = winner.size() - cnt - 1; i < winner.size(); i++) {
            System.out.println("승자명: " + ((Map.Entry<Player, Integer>) winner.get(i)).getKey().getNickName());
        }
    }
}
