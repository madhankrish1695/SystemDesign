package com.banquet.booking.service;

import com.banquet.booking.bo.Room;
import com.banquet.booking.model.Booking;

import java.util.*;

public class BookingService {
    List<Room> rooms;
    Map<String, Room> bookingToRoom;
    Map<String, Booking> bookingMap;

    public BookingService(int totalRooms) {
        rooms = new ArrayList<>();
        bookingToRoom = new HashMap<>();
        bookingMap = new HashMap<>();

        for (int i = 1; i <= totalRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    // ---------------- BOOK ----------------
    public synchronized String book(int start, int end) {
        validateTime(start, end);

        for (Room room : rooms) {
            if (room.canBook(start, end)) {
                String bookingId = UUID.randomUUID().toString();
                Booking booking = new Booking(bookingId, start, end);

                room.addBooking(booking);
                bookingMap.put(bookingId, booking);
                bookingToRoom.put(bookingId, room);

                return bookingId;
            }
        }
        return null;
    }

    // ---------------- CANCEL ----------------
    public synchronized boolean cancel(String bookingId) {
        Booking booking = bookingMap.remove(bookingId);
        if (booking == null) return false;

        Room room = bookingToRoom.remove(bookingId);
        return room.removeBooking(booking);
    }

    // ---------------- UPDATE ----------------
    public synchronized boolean update(String bookingId, int newStart, int newEnd) {
        validateTime(newStart, newEnd);

        Booking oldBooking = bookingMap.get(bookingId);
        if (oldBooking == null) return false;

        Room room = bookingToRoom.get(bookingId);

        // Temporarily remove old booking
        room.removeBooking(oldBooking);

        if (room.canBook(newStart, newEnd)) {
            oldBooking.start = newStart;
            oldBooking.end = newEnd;
            room.addBooking(oldBooking);
            return true;
        }

        // Rollback if update fails
        room.addBooking(oldBooking);
        return false;
    }

    private void validateTime(int start, int end) {
        if (start < 0 || end > 840 || start >= end) {
            throw new IllegalArgumentException("Invalid time slot");
        }
    }
}
