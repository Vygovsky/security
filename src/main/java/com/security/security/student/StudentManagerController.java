package com.security.security.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("manager/api/students")
public class StudentManagerController {

    private final static List<Student> studentList = Arrays.asList(
            new Student(1L, "student_Mary"),
            new Student(2L, "student_Sergey"),
            new Student(3L, "student_Roman")
    );

    public StudentManagerController() {
    }

    //hasRole('ROLE_'), hasAnyRole('ROLE_'), hasAuthority('permission'), hasAnyAuthority('permission'),

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getStudentList() {
        System.out.println("getStudentList");
        return studentList;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = {"{id}"})
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudentById(@PathVariable("id") Long id) {
        System.out.println("deleteStudentById");
        System.out.println(id);
    }

    @PutMapping(path = {"{id}"})
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudentById(@PathVariable("id") Long id, @RequestBody Student student) {
        System.out.println("updateStudentById");
        System.out.println(String.format("%s %s", id, student));
    }

}
