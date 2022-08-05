package kr.eddi.demo.entity.basic.twelveth;

import lombok.Getter;

@Getter
public class PlayerManager {
    private int playerNum;

    public PlayerManager(int playerNum) {
        this.playerNum = playerNum;
    }
}
