package kr.eddi.demo.repository.test;

import kr.eddi.demo.entity.test.TestStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TestStudentRepository extends JpaRepository<TestStudent, Long> {

    @Query("select ts from TestStudent ts join ts.classRoom cr where cr.roomName = :roomName")
    Optional<TestStudent> findTestStudentByRoomName (String roomName);

    @Query("select ts from TestStudent ts join ts.classRoom cr where cr.roomName = :roomName")
    List<TestStudent> findTestStudentListByRoomName (String roomName);
}
