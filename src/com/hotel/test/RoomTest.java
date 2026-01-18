package com.hotel.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import com.hotel.system.Room;
import com.hotel.system.RoomType;
import com.hotel.system.Guest;

public class RoomTest {

    @Test
    public void testRoomReservationTransition() {
        RoomType type = new RoomType("Double", 100.0);
        Room room = new Room(101, type);

        room.makeReservation();

        assertEquals(Room.RoomState.RESERVED, room.getState(), "Room should be RESERVED after booking.");
    }

    @ParameterizedTest
    @ValueSource(doubles = {100.0, 150.50, 200.0, 500.0})
    public void testRoomTypeCreation(double cost) {
        RoomType type = new RoomType("Luxury", cost);
        
        assertNotNull(type);
        assertEquals(cost, type.getCost(), 0.01);
    }

    @Test
    public void testCheckInGuest() {
        RoomType type = new RoomType("Single", 50.0);
        Room room = new Room(102, type);
        Guest guest = new Guest("Hashir", "Karachi");
        room.makeReservation(); 

        room.checkInGuest(guest);

        assertEquals(Room.RoomState.OCCUPIED, room.getState());
        assertEquals(guest, room.getOccupant());
    }

    @Test
    public void testInvalidStateTransition() {
        RoomType type = new RoomType("Suite", 200.0);
        Room room = new Room(103, type);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            room.checkOutGuest();
        });
    }
}