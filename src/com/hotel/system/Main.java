package com.hotel.system;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println(">>> STARTING HOTEL SIMULATION SEQUENCE <<<");

        // 1. Initialize Hotel Network
        HotelChain network = new HotelChain("Grand Royal Hotels");
        Hotel branch = new Hotel("Lahore Central Branch");

        // Define Inventory Types
        RoomType standard = new RoomType("Standard", 80.0);
        RoomType suite = new RoomType("Executive Suite", 250.0);
        
        branch.addRoomType(standard);
        branch.addRoomType(suite);

        // Populate Rooms
        branch.addRoom(new Room(301, standard));
        branch.addRoom(new Room(302, standard));
        branch.addRoom(new Room(401, suite));
        branch.addRoom(new Room(402, suite));

        network.addHotel(branch);
        System.out.println("[INFO] Network online. Branch connected: " + branch.getName());

        // 2. Register Actors (Guest & Payer)
        Guest newGuest = new Guest("Ali Hashir Rana", "Lahore, Punjab");
        ReservePayer account = new ReservePayer("5555-6666-7777-8888", "ACC-101");
        
        System.out.println("[INFO] Guest Profile Loaded: " + newGuest.getName());

        // 3. Execute Use Case: Create Reservation
        System.out.println("\n--- Processing Reservation Request ---");
        try {
            LocalDate today = LocalDate.now();
            LocalDate checkout = LocalDate.now().plusDays(5);
            
            Reservation booking = network.makeReservation("Lahore Central Branch", today, checkout, account, suite, 1);
            System.out.println("Reservation Confirmed! Reference #: " + booking.getNumber());
            
            // 4. Execute Use Case: Check-In
            System.out.println("\n--- Initiating Check-In Protocol ---");
            network.checkInGuest("Lahore Central Branch", 401, newGuest);
            System.out.println("Check-In Complete. Room 401 status updated to OCCUPIED.");

        } catch (Exception ex) {
            System.out.println("ERROR: Transaction failed - " + ex.getMessage());
        }

        System.out.println("\n>>> SIMULATION SUCCESSFULLY TERMINATED <<<");
    }
}