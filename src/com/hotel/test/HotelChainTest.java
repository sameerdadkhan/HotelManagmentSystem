package com.hotel.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import com.hotel.system.*;

public class HotelChainTest {

    private HotelChain chain;
    private ReservePayer payer;
    private RoomType standardType;

    @BeforeEach
    public void setup() {
        chain = new HotelChain("Global Hotels");
        Hotel hotel = new Hotel("City Branch");
        
        standardType = new RoomType("Standard", 100.0);
        
        hotel.addRoomType(standardType);
        hotel.addRoom(new Room(101, standardType)); 
        chain.addHotel(hotel);
        
        payer = new ReservePayer("1234567890", "ID001");
    }

    @Test
    public void testMakeReservationSuccess() {
        LocalDate start = LocalDate.now().plusDays(1);
        LocalDate end = LocalDate.now().plusDays(3);

        Reservation res = chain.makeReservation("City Branch", start, end, payer, standardType, 1);

        assertNotNull(res, "Reservation should be created successfully.");
        assertEquals(1, res.getRoomRequirements().size());
    }

    @Test
    public void testMakeReservationFailNotEnoughRooms() {
        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusDays(2);

        assertThrows(IllegalStateException.class, () -> {
            chain.makeReservation("City Branch", start, end, payer, standardType, 5);
        });
    }
}