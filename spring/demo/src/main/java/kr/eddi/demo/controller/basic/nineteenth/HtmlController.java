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
}
