package kr.eddi.demo.controller.basic.nineteenth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/html-control1")
public class HtmlController {

    @GetMapping("/list-tag")
    public String listTagTest() {
        log.info("list-tag");

        return "/basic/nineteenth/list-tag";
    }

    @GetMapping("/img-tag")
    public String imgTagTest() {
        log.info("img-tag");

        return "/basic/nineteenth/img-tag";
    }

    @GetMapping("/font-test")
    public String fontTest() {
        log.info("font-test");

        return "/basic/nineteenth/font";
    }

    @GetMapping("/color-test")
    public String colorTest() {
        log.info("color-test");

        return "/basic/nineteenth/color-style";
    }

    @GetMapping("table-test1")
    public String tableTest1() {
        log.info("table-test1");

        return "/basic/nineteenth/table-test1";
    }

    @GetMapping("table-test2")
    public String tableTest2() {
        log.info("table-test2");

        return "/basic/nineteenth/table-test2";
    }

    @GetMapping("table-quiz")
    public String tableQuiz() {
        log.info("table-quiz");

        return "/basic/nineteenth/table-quiz";
    }

    @GetMapping("table-test3")
    public String tableTest3() {
        log.info("table-test3");

        return "/basic/nineteenth/table-test3";
    }

    @GetMapping("table-test4")
    public String tableTest4() {
        log.info("table-test4");

        return "/basic/nineteenth/table-test4";
    }
}
