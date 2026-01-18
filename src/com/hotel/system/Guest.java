package com.hotel.system;

public class Guest {
    private String name;
    private String addressDetails;

    public Guest(String name, String addressDetails) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name Error: Guest name is required.");
        }
        if (addressDetails == null || addressDetails.trim().isEmpty()) {
            throw new IllegalArgumentException("Input Error: The address field cannot be left blank.");
        }
        this.name = name;
        this.addressDetails = addressDetails;
    }

    public String getName() {
        return name;
    }

    public String getAddressDetails() {
        return addressDetails;
    }
}