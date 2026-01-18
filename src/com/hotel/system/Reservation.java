package com.hotel.system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int number;
    private LocalDate reservationDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private ReservePayer payer;
    private List<HowMany> roomRequirements;

    public Reservation(int number, LocalDate startDate, LocalDate endDate, ReservePayer payer) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Scheduling Error: Check-in and check-out dates are required.");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Timeline Error: The check-out date must be after the check-in date.");
        }
        if (payer == null) {
            throw new IllegalArgumentException("Billing Error: Please specify who is paying for this reservation.");
        }
        
        this.number = number;
        this.reservationDate = LocalDate.now();
        this.startDate = startDate;
        this.endDate = endDate;
        this.payer = payer;
        this.roomRequirements = new ArrayList<>();
    }
    
    public void addRoomRequirement(RoomType type, int count) {
        if (type == null || count <= 0) {
            throw new IllegalArgumentException("Configuration Error: The selected room options are invalid.");
        }
        roomRequirements.add(new HowMany(count, type));
    }

    public int getNumber() {
    	return number; 
    }
    
    public LocalDate getStartDate() { 
    	return startDate; 
    }
    
    public LocalDate getEndDate() { 
    	return endDate; 
    }
    
    public List<HowMany> getRoomRequirements() { 
    	return roomRequirements; 
    }
    
    public ReservePayer getPayer() { 
    	return payer; 
    }
}