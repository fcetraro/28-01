package com.example.demo.controller;

import com.example.demo.model.DegreeDTO;
import com.example.demo.model.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @PostMapping("/degree")
    public DegreeDTO getDegree(@RequestBody StudentDTO student){
        return StudentService.generateDegree(student);
    }
}
