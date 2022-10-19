package kr.eddi.demo;

import kr.eddi.demo.entity.test.ClassRoom;
import kr.eddi.demo.entity.test.MemberTest;
import kr.eddi.demo.entity.test.TestStudent;
import kr.eddi.demo.repository.test.ClassRoomRepository;
import kr.eddi.demo.repository.test.MemberTestRepository;
import kr.eddi.demo.repository.test.TestStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StudentTestCase {

    @Autowired
    private TestStudentRepository studentRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Test
    void registerStudentTest() {
        //ClassRoom classRoom = new ClassRoom("test-room");
        //ClassRoom classRoom = new ClassRoom("save-room");
        ClassRoom classRoom = new ClassRoom("unique-room");
        classRoomRepository.save(classRoom);

        //TestStudent student = new TestStudent("test-student");
        //TestStudent student = new TestStudent("save-student");
        TestStudent student = new TestStudent("unique-student");

        student.setClassRoom(classRoom);
        studentRepository.save(student);
    }

    @Test
    void findStudent () {
        Optional<TestStudent> maybeStudent = studentRepository.findById((long) 1);
        TestStudent student = maybeStudent.get();

        System.out.println(student);
    }

    @Test
    void findAllStudents () {
        List<TestStudent> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    void findStudentWithRoomName () {
        // Optional의 경우 1개로 확정되는 경우에만 사용해야함.
        Optional<TestStudent> maybeStudent = studentRepository.findTestStudentByRoomName("unique-room");
        TestStudent student = maybeStudent.get();

        System.out.println(student);
    }

    @Test
    void findStudentListWithRoomName () {
        List<TestStudent> studentList = studentRepository.findTestStudentListByRoomName("save-room");

        System.out.println(studentList);
    }

    @Test
    void modifyStudent () {
        Optional<TestStudent> maybeStudent = studentRepository.findTestStudentByRoomName("unique-room");
        TestStudent student = maybeStudent.get();

        ClassRoom classRoom = new ClassRoom("modify-room");
        classRoomRepository.save(classRoom);

        student.setClassRoom(classRoom);
        studentRepository.save(student);
    }

    @Test
    void deleteStudent () {
        Optional<TestStudent> maybeStudent = studentRepository.findTestStudentByRoomName("modify-room");
        TestStudent student = maybeStudent.get();

        student.setClassRoom(null);
        studentRepository.delete(student);
    }
}
