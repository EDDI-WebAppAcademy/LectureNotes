package kr.eddi.demo.controller.jpa.member;

import kr.eddi.demo.controller.jpa.member.form.MemberRegisterForm;
import kr.eddi.demo.service.jpa.member.JpaMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("58th/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaMemberController {

    @Autowired
    private JpaMemberService service;

    @PostMapping("/check-email/{email}")
    public Boolean emailValidation(@PathVariable("email") String email) {
        log.info("emailValidation(): " + email);

        return service.emailValidation(email);
    }

    @PostMapping("/sign-up")
    public Boolean signUp(@RequestBody MemberRegisterForm form) {
        log.info("signUp: " + form);

        return service.signUp(form.toMemberRegisterRequest());
    }
}
