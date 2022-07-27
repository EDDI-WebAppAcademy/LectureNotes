package kr.eddi.demo.entity.basic.sixth.dirty;

import lombok.Getter;

@Getter
public class Player {
    private String nickName;
    private Dice dice;
    private final String ANONYMOUS = "anonymous";

    public Player(String name) {
        nickName = name;
        dice = new Dice();
    }

    public Player() {
        nickName = ANONYMOUS;
        dice = new Dice();
    }
}
