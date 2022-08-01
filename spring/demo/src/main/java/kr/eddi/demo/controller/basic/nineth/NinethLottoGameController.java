package kr.eddi.demo.controller.basic.nineth;

import kr.eddi.demo.entity.basic.nineth.LottoCardManager;
import kr.eddi.demo.utility.basic.nineth.NicknameGenerator;
import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/nineth")
public class NinethLottoGameController {

    @GetMapping("/lotto-game")
    public String lottoGame() {
        log.info("lottoGame()");



        return "0";
    }
}
