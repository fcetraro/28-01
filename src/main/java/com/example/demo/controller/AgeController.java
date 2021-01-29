package com.example.demo.controller;

import com.example.demo.model.AgeDTO;
import com.example.demo.service.AgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {
    @GetMapping("/{date}/{month}/{year}")
    public AgeDTO getAge(@PathVariable int date, @PathVariable int month, @PathVariable int year){
        return AgeService.getAgeDto(date, month, year);
    }
}

