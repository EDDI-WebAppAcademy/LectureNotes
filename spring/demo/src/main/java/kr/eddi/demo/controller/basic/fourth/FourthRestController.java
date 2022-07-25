package kr.eddi.demo.controller.basic.fourth;

import kr.eddi.demo.entity.basic.fourth.NumberLoop;
import kr.eddi.demo.entity.basic.fourth.Series;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fourth")
public class FourthRestController {

    private final int FIBONACCI = 1;
    private final int CUSTOM = 2;
    private final int EXAMPLE2_DATA = 20;
    private final int EXAMPLE3_DATA = 25;
    private final int PRINT = 3;
    private final int ADD = 7;
    private final int RANDOM = 8;
    private final int REFRESH_RANDOM_SUM = 16;
    private final int REFRESH_RANDOM_MOVEMENT = 32;
    private final int EVEN = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int NOT_IMPORTANT = 7777;

    @GetMapping("/find-fibonacci-series")
    public String findFibonacciSeries() {
        log.info("피보나치 수열을 검색합니다.");

        Series series = new Series(FIBONACCI, EXAMPLE2_DATA);
        return "피보나치 수열의 " + EXAMPLE2_DATA + "번째 항은 "
                + series.findSeriesNum();
    }

    // 내가 여기서 뭘 하려고 하는가 ?
    //
    @GetMapping("/find-custom-series")
    public String findCustomSeries() {
        log.info("커스텀 수열을 검색합니다.");

        Series series = new Series(CUSTOM, EXAMPLE3_DATA);
        return "커스텀 수열의 " + EXAMPLE3_DATA + "번째 항은 "
                + series.findSeriesNum();
    }

    @GetMapping("/find-even")
    public String findEven() {
        log.info("지정된 숫자에서 짝수를 찾습니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100);

        return numberLoop.operateWithCondition(EVEN);
    }

    @GetMapping("/find-three-times")
    public String findThreeTimes() {
        log.info("지정된 숫자에서 3의 배수를 찾습니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100);

        return numberLoop.operateWithCondition(THREE);
    }

    @GetMapping("/find-four-times-sum")
    public String findFourTimes() {
        log.info("findFourTimes()");

        NumberLoop numberLoop = new NumberLoop(1, 100, ADD);

        return numberLoop.operateWithCondition(FOUR);
    }

    @GetMapping("/find-specific-random-times")
    public String findSpecificRandomTimes() {
        log.info("findSpecificRandomTimes()");

        NumberLoop numberLoop = new NumberLoop(1, 100, RANDOM);

        return numberLoop.operateWithCondition(NOT_IMPORTANT);
    }

    @GetMapping("/find-refresh-random-sum")
    public String findRefreshRandomSum() {
        log.info("findRefreshRandomSum()");

        NumberLoop numberLoop = new NumberLoop(1, 100, REFRESH_RANDOM_SUM);

        return numberLoop.operateWithCondition(NOT_IMPORTANT);
    }

    @GetMapping("/find-refresh-random-movement")
    public String findRefreshRandomMovement() {
        log.info("findRefreshRandomMovement()");

        NumberLoop numberLoop = new NumberLoop(1, 100, REFRESH_RANDOM_MOVEMENT);

        return numberLoop.operateWithCondition(NOT_IMPORTANT);
    }
}
