package com.hotel.room;

import com.hotel.user.Customer;

public class FamilyRoom extends Room implements IPlace {

    private int numberOfRoom;
    private int numberOfPlaces;
    Customer familyCustomer;

    public FamilyRoom(int number, int numberOfPlaces, int numberOfRoom, double price) {
        super(number, price);
        this.numberOfRoom = numberOfRoom;
        this.numberOfPlaces = numberOfPlaces;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public Customer getFamilyCustomer() {
        return familyCustomer;
    }

    public void setFamilyCustomer(Customer familyCustomer) {
        this.familyCustomer = familyCustomer;
    }

    @Override
    public int getNumberOfFreePlaces() {
        //Add after create new class FamilyCastomer
        return numberOfPlaces;
    }
}
