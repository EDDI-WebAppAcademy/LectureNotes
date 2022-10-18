package kr.eddi.demo.service.jpa.member;

import kr.eddi.demo.entity.jpa.member.Authentication;
import kr.eddi.demo.entity.jpa.member.BasicAuthentication;
import kr.eddi.demo.entity.jpa.member.JpaMember;
import kr.eddi.demo.repository.member.AuthenticationRepository;
import kr.eddi.demo.repository.member.MemberRepository;
import kr.eddi.demo.service.jpa.member.request.MemberLoginRequest;
import kr.eddi.demo.service.jpa.member.request.MemberRegisterRequest;
import kr.eddi.demo.service.security.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class JpaMemberServiceImpl implements JpaMemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private RedisService redisService;

    @Override
    public Boolean emailValidation(String email) {
        Optional<JpaMember> maybeMember = memberRepository.findByEmail(email);

        if (maybeMember.isPresent()) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean signUp(MemberRegisterRequest request) {
        final JpaMember member = request.toMember();
        memberRepository.save(member);

        final BasicAuthentication auth = new BasicAuthentication(member,
                Authentication.BASIC_AUTH, request.getPassword());

        authenticationRepository.save(auth);

        return true;
    }

    @Override
    public String signIn(MemberLoginRequest request) {
        String email = request.getEmail();
        Optional<JpaMember> maybeMember = memberRepository.findByEmail(email);

        if (maybeMember.isPresent()) {
            JpaMember member = maybeMember.get();

            if (!member.isRightPassword(request.getPassword())) {
                throw new RuntimeException("패스워드가 잘못됨!");
            }

            UUID userToken = UUID.randomUUID();

            redisService.deleteByKey(userToken.toString());
            redisService.setKeyAndValue(userToken.toString(), member.getId());

            return userToken.toString();
        }

        throw new RuntimeException("가입된 사용자가 아님!");
    }
}
