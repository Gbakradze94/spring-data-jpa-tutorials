package com.gbakradze.springdatajpatutorial.repository;

import com.gbakradze.springdatajpatutorial.entity.CourseMaterial;
import com.gbakradze.springdatajpatutorial.entity.Guardian;
import com.gbakradze.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("hello@gmail.com")
                .firstName("Thomas")
                .lastName("Wayne")
                //.guardianName("Darth")
               // .guardianEmail("darth@wader.gmail.com")
                //.guardianMobile("332244")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void  saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("thomas@gmail.com")
                .name("Thomas")
                .mobile("12345")
                .build();
        Student student = Student.builder()
                .firstName("Martha")
                .emailId("martha@gmail.com")
                .lastName("Wayne")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    void printStudentByFirstName() {
        List<Student> students =
                studentRepository.findByFirstName("Thomas");

        System.out.println(students);
    }

    @Test
    void printStudentByFirstNameContaining() {
        List<Student> students =
                studentRepository.findByFirstNameContaining("th");

        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("Thomas");

        System.out.println(students);
    }

    @Test
    void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "thomas@gmail.com"
                );

        System.out.println(student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("thomas@gmail.com");

        System.out.println(firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student =
                studentRepository.getStudentByEmailAddressNative("thomas@gmail.com");
        System.out.println(student);
    }
    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("thomas@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
       studentRepository.updateStudentNameByEmailId(
                        "James",
                        "hello@gmail.com"
                );
    }

}
