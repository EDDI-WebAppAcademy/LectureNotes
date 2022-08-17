package kr.eddi.demo.controller.basic.nineteenth;

import kr.eddi.demo.entity.basic.second.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/19th")
public class EntityResponseController {

    @GetMapping("/member-response")
    public Member memberResponse() {
        Member member = new Member();

        return member;
    }

    @GetMapping("/member-list-response")
    public List<Member> memberListResponse() {
        List<Member> memberList = new ArrayList<>();

        Member member1 = new Member();
        memberList.add(member1);

        Member member2 = new Member();
        member2.setUserName("test-account");
        memberList.add(member2);

        return memberList;
    }
}
