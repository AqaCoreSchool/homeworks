package com.hotel.room;

public abstract class Room {

    private int number;
    private double price;
    private boolean booking;
    private double size;
    private boolean isPetFriendly;

    public Room(int number, double price, double size, boolean isPetFriendly) {
        this.number = number;
        this.price = price;
        this.size = size;
        this.isPetFriendly = isPetFriendly;
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

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSize() {
        return size;
    }

    public boolean isPetFriendly() {
        return isPetFriendly;
    }

    @Override
    public String toString() {
        String s = "";
        if (isPetFriendly()) s = "Pet friendly";
        return "Room type " + this.getClass().getSimpleName() +
                ", №" + number +
                ", size: " + size +
                " м2" +
                ", price=" + price +
                " UAH" +
                " " + s;
    }
}
