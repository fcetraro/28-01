package com.example.demo.model;

import java.util.List;

public class DegreeDTO {
    String message;
    double average;
    StudentDTO student;

    public DegreeDTO(String message, double average, StudentDTO student) {
        this.message = message;
        this.average = average;
        this.student = student;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}
