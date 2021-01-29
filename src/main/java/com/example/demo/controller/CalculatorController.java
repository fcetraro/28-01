package com.example.demo.controller;

import com.example.demo.model.RoomAreaDTO;
import com.example.demo.model.RoomDTO;
import com.example.demo.service.CalculatorService;
import com.example.demo.model.HouseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalculatorController {
    @PostMapping("/house/totalArea")
    public String calculateArea(@RequestBody HouseDTO house){
        return CalculatorService.calculateArea(house)+"";
    }
    @PostMapping("/house/getValue")
    public String calculateValue(@RequestBody HouseDTO house){
        return CalculatorService.calculateHouseValue(house);
    }
    @PostMapping("/house/biggestRoom")
    public RoomDTO getBiggestRoom(@RequestBody HouseDTO house){
        return CalculatorService.getBiggestRoom(house);
    }
    @PostMapping("/house/rooms")
    public List<RoomAreaDTO> getRooms(@RequestBody HouseDTO house){
        return CalculatorService.getRoomsArea(house);
    }
}
