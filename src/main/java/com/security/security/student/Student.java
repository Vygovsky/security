package com.security.security.student;

public class Student {
    private Long id;
    private String studentName;

    public Student() {
    }

    public Student(Long id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", StudentName='" + studentName + '\'' +
                '}';
    }
}
