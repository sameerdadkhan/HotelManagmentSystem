package com.hotel.system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<Room> rooms;
    private List<RoomType> roomTypes;
    private List<Reservation> reservations;

    public Hotel(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Input Error: Hotel name field cannot be blank.");
        }
        this.name = name;
        this.rooms = new ArrayList<>();
        this.roomTypes = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addRoomType(RoomType type) {
        if (type != null) roomTypes.add(type);
    }

    public void addRoom(Room room) {
        if (room != null) rooms.add(room);
    }
    
    public List<Room> getRooms() {
        return rooms;
    }
    
    public boolean isTypeAvailable(RoomType type, int quantityNeeded) {
        int count = 0;
        for (Room r : rooms) {
            if (r.getRoomType().equals(type) && r.isFree()) {
                count++;
            }
        }
        return count >= quantityNeeded;
    }

    public Reservation createReservation(LocalDate start, LocalDate end, ReservePayer payer) {
        int newId = reservations.size() + 100;
        Reservation res = new Reservation(newId, start, end, payer);
        reservations.add(res);
        return res;
    }
    
    public String getName() {
        return name;
    }
}