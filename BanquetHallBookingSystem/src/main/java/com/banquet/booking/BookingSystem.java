package com.banquet.booking;

import com.banquet.booking.model.Booking;
import com.banquet.booking.service.BookingManager;

import java.time.LocalTime;

public class BookingSystem {
    public static void main(String[] args) {
        BookingManager manager = new BookingManager();

        Booking b1 = manager.bookRoom(
                LocalTime.of(6, 0),
                LocalTime.of(8, 0)
        );

        Booking b2 = manager.bookRoom(
                LocalTime.of(9, 0),
                LocalTime.of(10, 0)
        );

        manager.cancelBooking(b1.bookingId);

        Booking b3 = manager.bookRoom(
                LocalTime.of(7, 0),
                LocalTime.of(8, 30)
        );

        System.out.println("Booking successful in room: " + b3.roomId);
    }
}
