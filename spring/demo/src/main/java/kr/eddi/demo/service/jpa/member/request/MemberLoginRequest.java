package kr.eddi.demo.service.jpa.member.request;

import kr.eddi.demo.entity.jpa.member.JpaMember;
import kr.eddi.demo.entity.jpa.member.MemberProfile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class MemberLoginRequest {

    private final String email;
    private final String password;
}
