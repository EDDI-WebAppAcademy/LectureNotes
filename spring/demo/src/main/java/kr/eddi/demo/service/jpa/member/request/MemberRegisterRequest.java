package kr.eddi.demo.service.jpa.member.request;

import kr.eddi.demo.entity.jpa.member.JpaMember;
import kr.eddi.demo.entity.jpa.member.MemberProfile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class MemberRegisterRequest {

    private final String email;
    private final String password;

    private final String city;
    private final String street;
    private final String addressDetail;
    private final String zipcode;

    public JpaMember toMember () {
        return new JpaMember(
                email,
                MemberProfile.of(city, street, addressDetail, zipcode)
        );
    }
}
