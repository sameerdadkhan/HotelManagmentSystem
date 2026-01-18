package com.hotel.system;

public class ReservePayer {
    private String creditCardDetails;
    private String id;

    public ReservePayer(String creditCardDetails, String id) {
        if (creditCardDetails == null || creditCardDetails.length() < 10) {
            throw new IllegalArgumentException("Payment Error: Credit Card details cannot be blank.");
        }
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Identity Error: A valid Payer ID is required.");
        }
        this.creditCardDetails = creditCardDetails;
        this.id = id;
    }

    public String getCreditCardDetails() {
        return creditCardDetails;
    }

    public String getId() {
        return id;
    }
}