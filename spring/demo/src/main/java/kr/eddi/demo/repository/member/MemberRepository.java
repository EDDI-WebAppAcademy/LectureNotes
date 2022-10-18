package kr.eddi.demo.repository.member;

import kr.eddi.demo.entity.jpa.member.JpaMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<JpaMember, Long> {

    @Query("select m from JpaMember m join fetch m.authentications where m.email = :email")
    Optional<JpaMember> findByEmail(String email);
}
