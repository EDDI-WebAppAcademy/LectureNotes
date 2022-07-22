package kr.eddi.demo.entity.basic.third;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Score {
    private int score;
    private Random random;
    private final int MIN = 0;
    private final int MAX = 100;

    public void makeRandomScore() {
        score = CustomRandom.makeIntCustomRandom(MIN, MAX);
    }

    public void makeRandomScore(int min) {
        score = CustomRandom.makeIntCustomRandom(min, MAX);
    }
}
