package com.example.demo.model;

public class RoomAreaDTO {
    private String name;
    private int area;

    public RoomAreaDTO(String name, int area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
