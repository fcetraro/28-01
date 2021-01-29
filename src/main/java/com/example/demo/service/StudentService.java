package com.example.demo.service;

import com.example.demo.model.*;

public class StudentService {
    private static double calculateAverage(StudentDTO student) {
        double totalScore = 0;
        for (SubjectDTO subject: student.getSubjects()) {
            totalScore+=subject.getScore();
        }
        return totalScore/student.getSubjects().size();
    }
    public static DegreeDTO generateDegree(StudentDTO student){
        double average = calculateAverage(student);
        String message = "Titulo correspondiente a "+student.getName();
        if(average>9.0){
            message = message+", MELI te envia felicitaciones por graduarte con mas de 9!!";
        }
        return new DegreeDTO(message,average,student);
    }
}
