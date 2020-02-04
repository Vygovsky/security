package com.security.security.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final static List<Student> studentList = Arrays.asList(
            new Student(1L, "student_Mary"),
            new Student(2L, "student_Sergey"),
            new Student(3L, "student_Roman")
    );



    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId) {
        return studentList.stream().filter(student -> studentId.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student " + studentId + " does not exists!"));

    }
}