package com.banquet.booking;

import com.banquet.booking.service.BookingService;
import com.banquet.booking.utils.TimeUtil;

public class BookingSystem {
    public static void main(String[] args) {
        BookingService service = new BookingService(10);

        int start = TimeUtil.toMinutes(6, 0);
        int end = TimeUtil.toMinutes(7, 0);

        String bookingId = service.book(start, end);
        System.out.println("Booked: " + bookingId);

        boolean updated = service.update(bookingId,
                TimeUtil.toMinutes(8, 0),
                TimeUtil.toMinutes(9, 0));
        System.out.println("Updated: " + updated);

        boolean cancelled = service.cancel(bookingId);
        System.out.println("Cancelled: " + cancelled);
    }
}
