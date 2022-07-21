package kr.eddi.demo.controller.basic.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/second")
public class SecondController {

    @GetMapping("/")
    public String secondRoot (Model model) {
        log.info("두번째 루트(메인) 페이지");

        model.addAttribute("test", 3.3f);
        return "/basic/second/test";
    }
}
