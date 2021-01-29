package com.example.demo.service;

import com.example.demo.model.HouseDTO;
import com.example.demo.model.RoomDTO;

public class CalculatorService {
    public static int calculateArea(HouseDTO house) {
        int totalArea = 0;
        for (RoomDTO room:house.getRooms()) {
            totalArea+=room.getWidth()*room.getLength();
        }
        return totalArea;
    }
}
