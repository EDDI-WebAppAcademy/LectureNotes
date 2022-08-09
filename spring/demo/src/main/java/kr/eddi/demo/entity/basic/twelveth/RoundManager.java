package kr.eddi.demo.entity.basic.twelveth;

import lombok.Getter;

@Getter
public class RoundManager {

    private int currentRound;

    public RoundManager() {
        currentRound = 0;
    }

    public void playPockerGame(PlayerManager playerManager) {
        System.out.println("현재 라운드: " + currentRound);
        // 6. 라운드를 시작한다.
        playerManager.playPockerGame(currentRound++);
    }
}
