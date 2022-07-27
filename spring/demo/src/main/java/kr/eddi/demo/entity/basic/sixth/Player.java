package kr.eddi.demo.entity.basic.sixth;

import lombok.Getter;

@Getter
public class Player {
    private String nickName;
    private Dice[] diceArr;
    private final String ANONYMOUS = "anonymous";
    private final int DEFAULT = 2;

    public Player(String name, int amountOfDice) {
        nickName = name;
        diceArr = new Dice[amountOfDice];
    }

    public Player(int amountOfDice) {
        nickName = ANONYMOUS;
        diceArr = new Dice[amountOfDice];
    }

    public Player() {
        nickName = ANONYMOUS;
        diceArr = new Dice[DEFAULT];
    }
}
