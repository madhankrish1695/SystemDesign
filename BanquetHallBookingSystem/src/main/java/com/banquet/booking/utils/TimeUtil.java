package com.banquet.booking.utils;

public class TimeUtil {
    public static int toMinutes(int hour, int minute) {
        return (hour - 6) * 60 + minute;
    }
}
