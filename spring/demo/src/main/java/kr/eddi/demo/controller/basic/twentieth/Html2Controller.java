package kr.eddi.demo.controller.basic.twentieth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/20th")
public class Html2Controller {

    @GetMapping("/img-size-test")
    public String imgSizeTest() {
        log.info(("img-size-test"));

        return "basic/twentieth/img-size-test";
    }

    @GetMapping("/img-caption-test")
    public String imgCaptionTest() {
        log.info(("img-caption-test"));

        return "basic/twentieth/img-caption-test";
    }

    @GetMapping("/display-method-test")
    public String displayMethodTest() {
        log.info(("display-method-test"));

        return "basic/twentieth/display-method-test";
    }

    @GetMapping("/display-method-with-css")
    public String displayMethodWithCss() {
        log.info(("display-method-with-css"));

        return "basic/twentieth/display-method-with-css";
    }
}
