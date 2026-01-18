package com.hotel.system;

public class HowMany {
    private int number;
    private RoomType roomType;

    public HowMany(int number, RoomType roomType) {
        if (number <= 0) {
            throw new IllegalArgumentException("Input Error: Please enter a quantity greater than zero.");
        }
        if (roomType == null) {
            throw new IllegalArgumentException("Selection Error: A valid Room Type is required.");
        }
        this.number = number;
        this.roomType = roomType;
    }

    public int getNumber() {
        return number;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}