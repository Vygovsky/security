package com.security.security.student;

public class Student {
    private final Long id;
    private final String StudentName;

    public Student(Long id, String studentName) {
        this.id = id;
        StudentName = studentName;
    }

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return StudentName;
    }
}
