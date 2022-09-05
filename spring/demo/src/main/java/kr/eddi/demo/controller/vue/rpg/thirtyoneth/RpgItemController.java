package kr.eddi.demo.controller.vue.rpg.thirtyoneth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgItemController {

    @GetMapping("/random-shop-item-lists")
    public String test () {
        log.info("test()");

        return "hi";
    }
}
