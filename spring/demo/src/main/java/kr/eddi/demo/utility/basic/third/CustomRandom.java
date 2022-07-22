package kr.eddi.demo.utility.basic.third;

import java.util.Random;

public class CustomRandom {

    public static int makeIntCustomRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
