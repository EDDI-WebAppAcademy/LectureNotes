package kr.eddi.demo.controller.basic.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
@Controller
public class FirstController {

    @GetMapping("/what-time-is-it")
    public String whatTimeIsIt (Locale locale, Model model) {
        log.info("지금 몇시냐 매서드가 동작합니다!");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);
        model.addAttribute("servTime", formattedDate);
        return "/basic/first/whatTimeIsIt";
    }
}
