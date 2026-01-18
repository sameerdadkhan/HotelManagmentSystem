package com.hotel.system;

public class Room {
    public enum RoomState {
        FREE, RESERVED, OCCUPIED
    }

    private int number;
    private RoomType roomType;
    private RoomState state;
    private Guest occupant;

    public Room(int number, RoomType roomType) {
        if (roomType == null) {
            throw new IllegalArgumentException("Configuration Error: Every room must be assigned a specific type.");
        }
        this.number = number;
        this.roomType = roomType;
        this.state = RoomState.FREE;
        this.occupant = null;
    }

    public int getNumber() { return number; }
    public RoomType getRoomType() { return roomType; }
    public RoomState getState() { return state; }
    public Guest getOccupant() { return occupant; }
 
    // Handling State Status Updates

    public void makeReservation() {
        if (state != RoomState.FREE) {
            throw new IllegalStateException("Availability Error: This room is unavailable and cannot be reserved.");
        }
        this.state = RoomState.RESERVED;
    }

    public void cancelReservation() {
        if (state != RoomState.RESERVED) {
            throw new IllegalStateException("Action Error: No reservation found to cancel for this room.");
        }
        this.state = RoomState.FREE;
    }

    public void checkInGuest(Guest guest) {
        if (state == RoomState.OCCUPIED) {
            throw new IllegalStateException("Status Error: This room is already currently occupied.");
        }
        if (guest == null) {
            throw new IllegalArgumentException("Assignment Error: A guest must be selected for this operation.");
        }
        this.occupant = guest;
        this.state = RoomState.OCCUPIED;
    }

    public void checkOutGuest() {
        if (state != RoomState.OCCUPIED) {
            throw new IllegalStateException("Operation Error: Cannot check out; the room is currently vacant.");
        }
        this.occupant = null;
        this.state = RoomState.FREE;
    }

    public boolean isFree() {
        return this.state == RoomState.FREE;
    }
}