package kr.eddi.demo.controller.basic.second;

import kr.eddi.demo.entity.basic.second.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/second/response")
public class ResponseTestController {

    // ResponseBody 리턴 결과를 자동으로 json 형태로 처리함
    // 그러므로 Controller에서도 json 데이터를 전송할 수 있다.
    @ResponseBody
    @GetMapping("/member")
    public Member responseMember() {
        log.info("responseMember() 동작");

        Member member = new Member();
        member.setUserName("내맘대로할거야");
        member.setPassword("싫어!!!");

        return member;
    }
}
