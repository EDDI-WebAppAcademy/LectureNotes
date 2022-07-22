package kr.eddi.demo.entity.basic.third;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.*;

import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
public class ClassRoom {
    private String roomName;
    private Student[] students;
    private final int MIN = 10;
    private final int MAX = 30;

    public void makeRandomStudents() {
        int randomStudentsNum = CustomRandom.makeIntCustomRandom(MIN, MAX);

        students = new Student[randomStudentsNum];

        for (int i = 0; i < randomStudentsNum; i++) {
            students[i] = new Student();
        }
    }

    public void takeTest() {
        for (int i = 0; i < students.length; i++) {
            students[i].takeTest();
        }
    }

    public void takeTest(int min) {
        for (int i = 0; i < students.length; i++) {
            students[i].takeTest(min);
        }
    }

    public float calcMean() {
        float mean = 0;

        for (int i = 0; i < students.length; i++) {
            mean += students[i].score.getScore();
        }

        return mean / students.length;
    }
}
