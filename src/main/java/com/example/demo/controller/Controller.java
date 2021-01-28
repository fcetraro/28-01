package com.example.demo.controller;

import com.example.demo.handler.AgeHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/{date}/{month}/{year}")
    public String getAge(@PathVariable int date, @PathVariable int month, @PathVariable int year){
        return AgeHandler.calculateAgeFromInts(date, month, year) + "";
    }
    @GetMapping("/")
    public String getAge(){
        System.out.println("Hola");
        return "";
    }
}

