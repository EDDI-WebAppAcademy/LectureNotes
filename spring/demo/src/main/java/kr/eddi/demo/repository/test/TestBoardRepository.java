package kr.eddi.demo.repository.test;

import kr.eddi.demo.entity.test.TestBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestBoardRepository extends JpaRepository<TestBoard, Long> {
}
