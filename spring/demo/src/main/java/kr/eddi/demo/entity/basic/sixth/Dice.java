package kr.eddi.demo.entity.basic.sixth;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;

@Getter
public class Dice {
    private int diceNum;
    private final int MIN = 1;
    private final int MAX = 6;

    public void rollDice() {
        this.diceNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
    }
}
