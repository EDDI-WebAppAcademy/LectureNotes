package kr.eddi.demo.entity.basic.fourth;

import lombok.Getter;

@Getter
public class Series {

    private final int FIBONACCI_SERIES = 1;
    private final int CUSTOM_SERIES = 2;
    private int[] seriesArr;

    public Series(int seriesNum, int length) {
        seriesArr = new int[length];

        if (seriesNum == FIBONACCI_SERIES) {
            makeFibonacciSeries();
        } else if (seriesNum == CUSTOM_SERIES) {
            makeCustomSeries();
        } else {
            System.out.println("잘못된 정보입니다!");
        }
    }

    public void makeFibonacciSeries() {
        seriesArr[0] = 1;
        seriesArr[1] = 1;

        for (int i = 2; i < seriesArr.length; i++) {
            seriesArr[i] = seriesArr[i - 1] + seriesArr[i - 2];
        }
    }

    public void makeCustomSeries() {
        seriesArr[0] = 1;
        seriesArr[1] = 1;
        seriesArr[2] = 1;
        seriesArr[3] = 2;

        for (int i = 4; i < seriesArr.length; i++) {
            seriesArr[i] = seriesArr[i - 2] + seriesArr[i - 3] + seriesArr[i - 4];
        }
    }

    public int findSeriesNum() {
        return seriesArr[seriesArr.length - 1];
    }
}
