package kr.eddi.demo.controller.vue.thirtieth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/30th/vue2spring")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class AxiosTestController {

    @GetMapping("/test")
    public void getVueDataTest () {
        log.info("getVueDataTest()");


    }
}
