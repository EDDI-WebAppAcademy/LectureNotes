package kr.eddi.demo.entity.vue;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RandomNumber {
    private int randomNumber;

    public RandomNumber () {
        randomNumber = CustomRandom.makeIntCustomRandom(1, 10);
    }
}
