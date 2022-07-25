package kr.eddi.demo.controller.basic.fourth;

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

    @GetMapping("/find-fibonacci-series")
    public String findFibonacciSeries() {
        log.info("피보나치 수열을 검색합니다.");

        Series series = new Series(FIBONACCI, EXAMPLE2_DATA);
        return "피보나치 수열의 " + EXAMPLE2_DATA + "번째 항은 "
                + series.findSeriesNum();
    }

    @GetMapping("/find-custom-series")
    public String findCustomSeries() {
        log.info("커스텀 수열을 검색합니다.");

        Series series = new Series(CUSTOM, EXAMPLE3_DATA);
        return "커스텀 수열의 " + EXAMPLE3_DATA + "번째 항은 "
                + series.findSeriesNum();
    }
}
