package com.banquet.booking.bo;

import com.banquet.booking.model.Booking;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Room {
    public int roomId;
    public List<Booking> bookings;

    public Room(int roomId) {
        this.roomId = roomId;
        this.bookings = new ArrayList<>();
    }

    public boolean canBook(LocalTime start, LocalTime end) {
        for (Booking booking : bookings) {
            // overlap check
            if (!(end.isBefore(booking.start) || start.isAfter(booking.end))) {
                return false;
            }
        }
        return true;
    }

    public Booking addBooking(LocalTime start, LocalTime end) {
        Booking booking = new Booking(roomId, start, end);
        bookings.add(booking);
        bookings.sort((a, b) -> a.start.compareTo(b.start));
        return booking;
    }

    public boolean removeBooking(String bookingId) {
        return bookings.removeIf(b -> b.bookingId.equals(bookingId));
    }
}
