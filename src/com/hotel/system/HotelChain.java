package com.hotel.system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelChain {
    private String name;
    private List<Hotel> hotels;

    public HotelChain(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Input Error: Please provide a name for the Hotel Chain.");
        }
        this.name = name;
        this.hotels = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        if (hotel != null) {
            hotels.add(hotel);
        }
    }
    
    public String getName() {
        return name;
    }

    // --- Controller Methods (Delegates to Hotel/Room) ---

    public Reservation makeReservation(String hotelName, LocalDate start, LocalDate end, ReservePayer payer, RoomType type, int count) {
        Hotel hotel = findHotel(hotelName);
        if (hotel == null) throw new IllegalArgumentException("Search Error: We couldn't find the specified hotel in our records.");
        if (!hotel.isTypeAvailable(type, count)) {
            throw new IllegalStateException("Capacity Error: Sorry, there are not enough rooms available to complete this booking.");
        }

        Reservation res = hotel.createReservation(start, end, payer);
        res.addRoomRequirement(type, count);
        return res;
    }

    public void checkInGuest(String hotelName, int roomNumber, Guest guest) {
        Room room = findRoom(hotelName, roomNumber);
        if (room == null) throw new IllegalArgumentException("Lookup Error: The specific room you requested does not exist.");
        
        room.checkInGuest(guest);
    }

    public void checkOutGuest(String hotelName, int roomNumber) {
        Room room = findRoom(hotelName, roomNumber);
        if (room == null) throw new IllegalArgumentException("Lookup Error: The specific room you requested does not exist.");
        
        room.checkOutGuest();
    }

    public void cancelReservation(String hotelName, int roomNumber) {
        Room room = findRoom(hotelName, roomNumber);
        if (room == null) throw new IllegalArgumentException("Lookup Error: The specific room you requested does not exist.");
        
        room.cancelReservation();
    }

    // --- Helper Methods to Find Objects ---

    private Hotel findHotel(String name) {
        for (Hotel h : hotels) {
            if (h.getName().equalsIgnoreCase(name)) return h;
        }
        return null;
    }

    private Room findRoom(String hotelName, int roomNumber) {
        Hotel hotel = findHotel(hotelName);
        if (hotel != null) {
            for (Room r : hotel.getRooms()) {
                if (r.getNumber() == roomNumber) return r;
            }
        }
        return null;
    }
}