package com.banquet.booking.service;

import com.banquet.booking.bo.Room;
import com.banquet.booking.model.Booking;

import java.time.LocalTime;
import java.util.*;

public class BookingManager {
    public static final int TOTAL_ROOMS = 10;

    public Map<Integer, Room> rooms;
    public Map<String, Booking> bookingIndex;

    public BookingManager() {
        rooms = new HashMap<>();
        bookingIndex = new HashMap<>();

        for (int i = 1; i <= TOTAL_ROOMS; i++) {
            rooms.put(i, new Room(i));
        }
    }

    // BOOK ROOM
    public Booking bookRoom(LocalTime start, LocalTime end) {
        for (Room room : rooms.values()) {
            if (room.canBook(start, end)) {
                Booking booking = room.addBooking(start, end);
                bookingIndex.put(booking.bookingId, booking);
                return booking;
            }
        }
        return null; // no room available
    }

    // CANCEL BOOKING
    public boolean cancelBooking(String bookingId) {
        Booking booking = bookingIndex.get(bookingId);
        if (booking == null) return false;

        Room room = rooms.get(booking.roomId);
        boolean removed = room.removeBooking(bookingId);

        if (removed) {
            bookingIndex.remove(bookingId);
        }
        return removed;
    }

    // UPDATE BOOKING
    public Booking updateBooking(String bookingId, LocalTime newStart, LocalTime newEnd) {
        Booking oldBooking = bookingIndex.get(bookingId);
        if (oldBooking == null) return null;

        cancelBooking(bookingId);
        Booking newBooking = bookRoom(newStart, newEnd);

        if (newBooking == null) {
            // rollback old booking
            Room room = rooms.get(oldBooking.roomId);
            Booking rollback = room.addBooking(oldBooking.start, oldBooking.end);
            bookingIndex.put(rollback.bookingId, rollback);
            return null;
        }
        return newBooking;
    }
}
