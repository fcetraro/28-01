package com.example.demo.controller;

import com.example.demo.handler.AgeHandler;
import com.example.demo.handler.CalculatorHandler;
import com.example.demo.model.HouseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @PostMapping("/calculator")
    public int calculateArea(@RequestBody HouseDTO house){
        return CalculatorHandler.calculateArea(house);
    }
}
