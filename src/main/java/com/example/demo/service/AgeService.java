package com.example.demo.service;

import com.example.demo.model.AgeDTO;

import java.time.LocalDate;
import java.time.Period;

public class AgeService {
    public static AgeDTO getAgeDto(int date, int month, int year){
        String stringBirth=date+"/"+month+"/"+year;
        return new AgeDTO(stringBirth, calculateAgeFromInts(date,month,year));
    }
    private static int calculateAgeFromInts(int date, int month, int year){
        LocalDate birthDate = LocalDate.of(year,month,date);
        return calculateAge(birthDate, LocalDate.now());
    }
    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
