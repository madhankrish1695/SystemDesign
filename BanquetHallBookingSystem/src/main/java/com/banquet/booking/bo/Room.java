package com.banquet.booking.bo;

import com.banquet.booking.model.Booking;

import java.util.Comparator;
import java.util.TreeSet;

public class Room {
    public int roomId;
    public TreeSet<Booking> bookings;

    public Room(int roomId) {
        this.roomId = roomId;
        this.bookings = new TreeSet<>(Comparator.comparingInt(b -> b.start));
    }

    public boolean canBook(int start, int end) {
        Booking probe = new Booking("", start, end);

        Booking floor = bookings.floor(probe);
        if (floor != null && floor.end > start) return false;

        Booking ceiling = bookings.ceiling(probe);
        if (ceiling != null && ceiling.start < end) return false;

        return true;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public boolean removeBooking(Booking booking) {
        return bookings.remove(booking);
    }
}
