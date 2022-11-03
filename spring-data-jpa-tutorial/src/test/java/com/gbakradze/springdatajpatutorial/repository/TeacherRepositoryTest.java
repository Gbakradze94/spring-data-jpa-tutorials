package com.gbakradze.springdatajpatutorial.repository;

import com.gbakradze.springdatajpatutorial.entity.Course;
import com.gbakradze.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .courseTitle("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .courseTitle("Java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Qutub")
                .lastName("Khan")
                //.courses(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}
