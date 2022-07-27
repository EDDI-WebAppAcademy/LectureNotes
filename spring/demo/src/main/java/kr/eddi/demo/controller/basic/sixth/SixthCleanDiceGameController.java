package kr.eddi.demo.controller.basic.sixth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sixth-clean")
public class SixthCleanDiceGameController {

    @GetMapping("/dice-game-starter")
    public String diceGameStarter() {
        return "고고싱";
    }
}
