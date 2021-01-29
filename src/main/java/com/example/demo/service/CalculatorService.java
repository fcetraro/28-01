package com.example.demo.service;

import com.example.demo.model.HouseDTO;
import com.example.demo.model.RoomAreaDTO;
import com.example.demo.model.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private final static int METER_VALUE = 800;
    private static int calculateRoomArea(RoomDTO room){
        return room.getWidth()*room.getLength();
    }
    public static int calculateArea(HouseDTO house) {
        int totalArea = 0;
        for (RoomDTO room:house.getRooms()) {
            totalArea+=calculateRoomArea(room);
        }
        return totalArea;
    }
    public static String calculateHouseValue(HouseDTO house) {
        return calculateArea(house)*METER_VALUE + " USD";
    }
    public static RoomDTO getBiggestRoom(HouseDTO house) {
        int maxArea=0;
        RoomDTO maxAreaRoom=new RoomDTO();
        for (RoomDTO room:house.getRooms()) {
            if(maxArea<calculateRoomArea(room)){
                maxArea=calculateRoomArea(room);
                maxAreaRoom=room;
            }
        }
        return maxAreaRoom;
    }
    public static List<RoomAreaDTO> getRoomsArea(HouseDTO house) {
        List<RoomAreaDTO> rooms = new ArrayList<>();
        RoomDTO maxAreaRoom=new RoomDTO();
        for (RoomDTO room:house.getRooms()) {
            rooms.add(new RoomAreaDTO(room.getName(),calculateRoomArea(room)));
        }
        return rooms;
    }
}
