package com.banquet.booking.model;

import java.time.LocalTime;
import java.util.UUID;

public class Booking {
    public String bookingId;
    public int roomId;
    public LocalTime start;
    public LocalTime end;

    public Booking(int roomId, LocalTime start, LocalTime end) {
        this.bookingId = UUID.randomUUID().toString();
        this.roomId = roomId;
        this.start = start;
        this.end = end;
    }
}
