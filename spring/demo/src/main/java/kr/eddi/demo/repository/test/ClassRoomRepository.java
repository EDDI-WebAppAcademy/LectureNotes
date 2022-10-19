package kr.eddi.demo.repository.test;

import kr.eddi.demo.entity.test.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
}
