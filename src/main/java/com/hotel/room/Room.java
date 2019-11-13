package com.hotel.room;

public abstract class Room {

    private int number;
    private double price;
    private boolean booking;

    public Room(int number, double price) {
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBooking() {
        return booking;
    }

    public void setBooking(boolean booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Room type " +this.getClass().getSimpleName()+
                ", №" + number +
                ", price=" + price +
                " UAH";
    }
}
