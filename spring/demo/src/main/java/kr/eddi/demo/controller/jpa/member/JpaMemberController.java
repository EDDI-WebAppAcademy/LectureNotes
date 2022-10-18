package kr.eddi.demo.controller.jpa.member;

import kr.eddi.demo.controller.jpa.member.request.BoardRequest;
import kr.eddi.demo.entity.jpa.boards.Board;
import kr.eddi.demo.service.jpa.board.BoardService;
import kr.eddi.demo.service.jpa.member.JpaMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
