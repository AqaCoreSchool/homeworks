package com.hotel.room;

import com.hotel.user.Customer;

public class FamilyRoom extends Room implements IPlace {

    private int numberOfRoom;
    private int numberOfPlaces;
    private Customer familyCustomer;

    public FamilyRoom(int number, double price, double size, int numbOfPlaces, int numbOfRoom, boolean isPetFriendly) {
        super(number, price, size, isPetFriendly);
        this.numberOfRoom = numbOfRoom;
        this.numberOfPlaces = numbOfPlaces;
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
