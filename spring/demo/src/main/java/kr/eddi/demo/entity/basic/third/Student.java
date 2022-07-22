package kr.eddi.demo.entity.basic.third;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    private String major;
    private int age;

    private final String[] names = {
            "가가가", "나나나", "다다다", "라라라", "마마마",
            "바바바", "사사사", "아아아", "자자자", "차차차"
    };
    private final String[] majors = {
            "물리학", "수학", "화학", "영문학", "중어중문학",
            "일어일문학", "컴퓨터공학", "전자공학", "반도체공학", "인공지능"
    };
    private final int MIN = 20;
    private final int MAX = 39;

    Score score;

    public Student() {
        score = new Score();
        name = names[CustomRandom.makeIntCustomRandom(0, 10)];
        major = majors[CustomRandom.makeIntCustomRandom(0, 10)];
        age = CustomRandom.makeIntCustomRandom(MIN, MAX);
    }

    public void takeTest() {
        score.makeRandomScore();
    }

    public void takeTest(int min) {
        score.makeRandomScore(min);
    }
}
