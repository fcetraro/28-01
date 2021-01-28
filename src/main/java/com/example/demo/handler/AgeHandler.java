package com.example.demo.handler;

import java.time.LocalDate;
import java.time.Period;

public class AgeHandler {
    public static int calculateAgeFromInts(int date, int month, int year){
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
