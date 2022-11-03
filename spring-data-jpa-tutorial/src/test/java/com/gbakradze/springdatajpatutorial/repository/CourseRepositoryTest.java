package com.gbakradze.springdatajpatutorial.repository;

import com.gbakradze.springdatajpatutorial.entity.Course;
import com.gbakradze.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses =
                courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher
                .builder()
                .firstName("Pryianka")
                .lastName("Singh")
                .build();

        Course course = Course
                .builder()
                .courseTitle("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}