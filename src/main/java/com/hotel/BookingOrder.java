package com.hotel;

import com.hotel.exceptions.IncorrectInputDateException;
import com.hotel.exceptions.IncorrectInputNumberOfMembersException;
import com.hotel.room.Room;

import java.time.LocalDate;

public class BookingOrder {
    private Room room;
    private LocalDate bookingDateFrom;
    private int bookingDays;
    private int numberOfMember;

    public BookingOrder(Room room, LocalDate bookingDateFrom, int bookingDays, int numberOfMember) {
        this.room = room;
        this.bookingDays = bookingDays;
        if (bookingDateFrom.isBefore(LocalDate.now())) {
            this.bookingDateFrom = bookingDateFrom;
        } else {
            throw new IncorrectInputDateException("Booking date must be real");
        }
        if (numberOfMember >= 1) {
            this.numberOfMember = numberOfMember;
        } else {
            throw new IncorrectInputNumberOfMembersException("Incorrect number of your members");
        }
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getBookingDateFrom() {
        return bookingDateFrom;
    }

    public int getBookingDays() {
        return bookingDays;
    }

    public int getNumberOfMember() {
        return numberOfMember;
    }

}
