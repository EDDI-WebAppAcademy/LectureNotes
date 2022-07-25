package kr.eddi.demo.entity.basic.fourth;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberLoop {

    private int start;
    private int end;
    private int operationMode;

    private final int PRINT = 3;
    private final int ADD = 7;
    private final int RANDOM = 8;
    private final int REFRESH_RANDOM_SUM = 16;
    private final int REFRESH_RANDOM_MOVEMENT = 32;

    public NumberLoop(int start, int end) {
        this.start = start;
        this.end = end;
        this.operationMode = PRINT;
    }

    public String printSimpleFindMatching(int condition) {
        String msg = "";

        for (int i = start; i <= end; i++) {
            if (i % condition == 0) {
                msg += i + ", ";
            }
        }

        return msg;
    }

    public String printSumFindMatching(int condition) {
        String msg = "";
        int sum = 0;

        for (int i = start; i <= end; i++) {
            if (i % condition == 0) {
                sum += i;
            }
        }

        return "최종 합산 결과는 " + sum;
    }

    public String printRandomFindMatching(int condition) {
        final int MIN = 2;
        final int MAX = 10;

        String msg = "";
        int randNum = CustomRandom.makeIntCustomRandom(MIN, MAX);

        for (int i = start; i <= end; i++) {
            if (i % randNum == 0) {
                msg += i + ", ";
            }
        }

        return msg;
    }

    public String printSumRefreshRandomFindMatching(int condition) {
        final int MIN = 2;
        final int MAX = 10;

        String msg = "";
        int randNum;
        int sum = 0;

        // 7의 배수가 나왔음
        // 그 다음 루프에서 9의 배수
        // 그 다음 루프에서 2의 배수
        // 그 다음 루프에서 4의 배수
        randNum = CustomRandom.makeIntCustomRandom(MIN, MAX);

        for (int i = start; i <= end; i++) {
            if (i % randNum == 0) {
                randNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
                sum += i;
            }
        }

        return "최종 합산 결과는 " + sum;
    }

    public String printRefreshRandomMovement(int condition) {
        final int MIN = 2;
        final int MAX = 10;

        int randNum;
        int sum = 0;

        for (int i = start; i <= end; i += randNum) {
            randNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
            sum += randNum;
        }

        return "최종 합산 결과는 " + sum;
    }

    public String operateWithCondition (int condition) {

        switch (operationMode) {
            case PRINT:
                return printSimpleFindMatching(condition);

            case ADD:
                return printSumFindMatching(condition);

            case RANDOM:
                return printRandomFindMatching(condition);

            case REFRESH_RANDOM_SUM:
                return printSumRefreshRandomFindMatching(condition);

            case REFRESH_RANDOM_MOVEMENT:
                return printRefreshRandomMovement(condition);

            default:
                System.out.println("잘못된 값을 입력하였습니다!");
                return null;
        }
    }
}
