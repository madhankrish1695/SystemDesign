🏢 Banquet Hall Room Booking System – System Design Problem
📌 Problem Statement

You are a receptionist at a banquet hall that has 10 rooms available for booking every day between 6:00 AM and 8:00 PM.

Customers approach you to book a room for a specific time interval (for example, a meeting from 6:00 AM to 8:00 AM).

Your task is to design an in-memory room booking system that efficiently allocates rooms while ensuring no over-booking occurs.

🎯 Functional Requirements

The system should support 10 uniquely identifiable rooms.

Customers can request a booking by providing:

Start time

End time

Each booking must be assigned to exactly one room.

A room must not have overlapping bookings.

The system should efficiently utilize rooms, including handling gaps between two bookings in the same room.

The system should support the following operations:

Book a room

Cancel a booking

Update an existing booking

If no room is available for the requested time slot, the booking should fail gracefully.

⚙️ Non-Functional Requirements

The solution should be implemented in Java.

The design should be suitable for a system design / low-level design interview.

The system can be in-memory (no database required).

Concurrency handling is not required unless explicitly mentioned.

Code should be clean, readable, and extensible.

📏 Constraints

Number of rooms: 10

Operating hours: 6:00 AM to 8:00 PM

Time granularity: minutes

All bookings are for a single day

✅ Expected Outcome

A clean object-oriented design (e.g., Booking, Room, BookingManager).

Proper handling of overlapping bookings.

Efficient room allocation with gap handling.

Ability to update and cancel bookings without data inconsistency.

❓ Follow-Up Questions (Optional)

How would you make this system thread-safe?

How would you persist bookings using a database?

How would the design change if the number of rooms increases significantly?

How would you optimize room allocation further?