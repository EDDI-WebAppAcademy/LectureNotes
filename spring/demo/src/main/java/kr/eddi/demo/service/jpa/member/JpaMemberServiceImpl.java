package kr.eddi.demo.service.jpa.member;

import kr.eddi.demo.entity.jpa.member.JpaMember;
import kr.eddi.demo.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class JpaMemberServiceImpl implements JpaMemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public Boolean emailValidation(String email) {
        Optional<JpaMember> maybeMember = repository.findByEmail(email);

        if (maybeMember.isPresent()) {
            return false;
        }

        return true;
    }
}
