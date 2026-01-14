package com.banquet.booking.model;

public class Booking {
    public String bookingId;
    public int start; // minutes from 6 AM
    public int end;

    public Booking(String bookingId, int start, int end) {
        this.bookingId = bookingId;
        this.start = start;
        this.end = end;
    }
}
