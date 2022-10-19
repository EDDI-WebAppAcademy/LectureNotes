package kr.eddi.demo;

import kr.eddi.demo.entity.test.MemberTest;
import kr.eddi.demo.repository.test.MemberTestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private MemberTestRepository repository;

	@Test
	void contextLoads() {
		MemberTest memberTest = new MemberTest("test", "gogosing");

		repository.save(memberTest);
	}

}
