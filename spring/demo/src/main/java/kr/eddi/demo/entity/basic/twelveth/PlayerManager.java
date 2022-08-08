package kr.eddi.demo.entity.basic.twelveth;

import lombok.Getter;

@Getter
public class PlayerManager {
    private int playerNum;
    private PockerCard pockerCard;

    public PlayerManager(int playerNum) {
        this.playerNum = playerNum;
        pockerCard = new PockerCard();
        pockerCard.shuffle();
    }

    public void playPockerGame() {
        // 4. 참여 순서대로 플레이어들에게 패를 돌린다. -> 카드 생성

    }
}
