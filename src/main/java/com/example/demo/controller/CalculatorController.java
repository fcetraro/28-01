package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import com.example.demo.model.HouseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @PostMapping("/calculator")
    public String calculateArea(@RequestBody HouseDTO house){
        return CalculatorService.calculateArea(house)+"";
    }
}
