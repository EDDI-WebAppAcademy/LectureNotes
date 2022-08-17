package kr.eddi.demo.controller.basic.nineteenth;

import kr.eddi.demo.entity.basic.second.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/19th")
public class EntityResponseController {

    @GetMapping("/member-response")
    public Member memberResponse() {
        Member member = new Member();

        return member;
    }
}
