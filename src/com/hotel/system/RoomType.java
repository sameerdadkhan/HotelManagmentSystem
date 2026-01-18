package com.hotel.system;

public class RoomType {
    private String kind;
    private double cost;

    public RoomType(String kind, double cost) {
        if (kind == null || kind.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking Error: Please select a room type to proceed.");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Pricing Error: The cost amount cannot be negative.");
        }
        this.kind = kind;
        this.cost = cost;
    }

    public String getKind() {
        return kind;
    }

    public double getCost() {
        return cost;
    }
}