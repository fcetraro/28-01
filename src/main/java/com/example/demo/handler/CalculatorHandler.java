package com.example.demo.handler;

import com.example.demo.model.HouseDTO;
import com.example.demo.model.RoomDTO;

import java.time.LocalDate;
import java.time.Period;

public class CalculatorHandler {
    public static int calculateArea(HouseDTO house) {
        int totalArea = 0;
        for (RoomDTO room:house.getRooms()) {
            totalArea+=room.getWidth()*room.getLength();
        }
        return totalArea;
    }
}
