package com.company;

import java.util.Date;

abstract public class Vehicle {
    private String owner;
    private String number;
    private String type;
    private Date dateIn;
    private Date dateOut;
    private int pricePerHour;
    private int bill;
    private int duration;

    public Vehicle() {
        this.dateIn = new Date();
        this.dateOut = new Date();
    }

    public Vehicle(String owner, String number) {
        this.owner = owner;
        this.number = number;
        this.dateIn = new Date();
        this.dateOut = new Date();
    }

    abstract void Standard();

    @Override
    public String toString() {
        return this.type + " number: " + this.number + ". Owner: " + this.owner + ". Check in: " + this.getDateIn(); //
    }

    public boolean checkIn() {
        if (Main.freeLots >= 0) {
            Date dateIn = new Date();
            Main.freeLots = Main.freeLots - 1;
            return true;
        } else return false;
    }

    public boolean checkOut() {
        if (Main.freeLots < Main.lotCount) {
            Main.freeLots = Main.freeLots + 1;
            this.dateOut = new Date();
            System.out.println("You need to pay: " + (getBill()) + " UAH");
            return true;
        } else
            System.out.println("Oops, You aren't checked in. You need to do it!");
        return false;
    }

    public int getDuration() {
        if (dateOut.after(dateIn)) {
            duration = (int) ((dateOut.getTime() - dateIn.getTime())); // need add "/3600000" now without this? just for testing
            return duration;
        } else
            return 0;
    }

    public int getBill() {
        return this.pricePerHour * this.getDuration();
    }

    public void setVehicle(String number, String owner) {
        this.number = number;
        this.owner = owner;
        this.dateIn = new Date();
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = new Date();
    }

    public Date getDateOut() {
        return this.dateOut;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return pricePerHour;
    }

    public void setPrice(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

}
