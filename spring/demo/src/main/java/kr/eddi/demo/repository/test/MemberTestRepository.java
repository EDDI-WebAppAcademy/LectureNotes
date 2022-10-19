package kr.eddi.demo.repository.test;

import kr.eddi.demo.entity.test.MemberTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTestRepository extends JpaRepository<MemberTest, Long> {
}
