package com.example.demo;

import com.example.demo.model.HouseDTO;
import com.example.demo.model.RoomDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {
    public static HouseDTO getHouseTest(){
        HouseDTO anObject = new HouseDTO();
        anObject.setName("testName");
        anObject.setAddress("testAddress");
        RoomDTO aRoom = new RoomDTO();
        aRoom.setName("testRoomName");
        aRoom.setWidth(1);
        aRoom.setLength(2);
        RoomDTO anotherRoom = new RoomDTO();
        anotherRoom.setName("anotherTestRoomName");
        anotherRoom.setWidth(2);
        anotherRoom.setLength(2);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(aRoom);
        rooms.add(anotherRoom);
        anObject.setRooms(rooms);
        return anObject;
    }
}
