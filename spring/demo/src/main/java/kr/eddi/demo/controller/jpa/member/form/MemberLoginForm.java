package kr.eddi.demo.controller.jpa.member.form;

import kr.eddi.demo.service.jpa.member.request.MemberLoginRequest;
import kr.eddi.demo.service.jpa.member.request.MemberRegisterRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberLoginForm {

    private String email;
    private String password;

    public MemberLoginRequest toLoginRequest () {
        return new MemberLoginRequest(email, password);
    }
}
