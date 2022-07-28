package kr.eddi.demo.entity.basic.sixth.dirty;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;

@Getter
public class Dice {
    // ??? 뭐지 ? 왜 갑자기 내가 여러명이 된 것이지 ?
    // 패러다임 불일치
    // 만약 이걸 아름답게 해결하고 싶다면 ? 엎어야한다.
    private int[] diceNum;
    private final int MIN = 1;
    private final int MAX = 6;
    private final int DEFAULT = 2;

    Score score;

    // 이건 또 뭐냐 ?
    // 얘가 관리하는건 뭐야 ?
    public Dice() {
        diceNum = new int[DEFAULT];
        score = new Score();
    }

    // ??? 뭐지 ?
    public void rollDice() {
        int sum = 0;

        for (int i = 0; i < DEFAULT; i++) {
            this.diceNum[i] = CustomRandom.makeIntCustomRandom(MIN, MAX);
            sum += this.diceNum[i];
        }

        score.setTotalScore(sum);
    }
}