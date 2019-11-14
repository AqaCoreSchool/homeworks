package ParkingLot;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ParkingLot.VehicleParking.*;

abstract public class Vehicle {
    private String owner;
    private String number;
    private String type;
    private Date dateIn;
    private Date dateOut;
    private int pricePerHour;
    private int bill;
    private int duration;
    private int lotNumber;

    Vehicle() {
        this.dateIn = new Date();
        this.dateOut = new Date();
    }

    Vehicle(String owner, String number) {
        this.owner = owner;
        this.number = number;
        this.dateIn = new Date();
        this.dateOut = new Date();
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    abstract void standard();

    @Override
    public String toString() {
        return this.type + " number: " + this.number + ". Owner: " + this.owner + ". Check in: " + this.getDateIn(); //
    }


    void checkIn(Vehicle vehicle) {
        if ((freeLots > 0) && validateNumber()) { //// треба переробити
            Date dateIn = new Date();
            freeLots = freeLots - 1;
            assignCarToLot(this.number);
            addCarToMap(vehicle.getNumber(), vehicle);
        }
        else
            System.out.println("There aren't available lots");
    }

   void checkOut(Vehicle vehicle) {
        if (freeLots < VehicleParking.LOT_COUNT) {
            freeLots = freeLots + 1;
            this.dateOut = new Date();
            deleteCarFromLot(this.number);
            carAll.remove(vehicle);
            carNumLotMap.remove(this.number);
            System.out.println("You need to pay: " + (getBill()) + " UAH");
        } else
            System.out.println("Oops, You aren't checked in. You need to do it!");
    }

    private void assignCarToLot(String number) {
        if ((VehicleParking.lots.size() < VehicleParking.LOT_COUNT)) {
            VehicleParking.lots.add(number);
            System.out.println("You have place №:" + (VehicleParking.lots.indexOf(number) + 1));
        } else {
            System.out.println("Sorry, there's no lots available.");
        }
    }

    private void deleteCarFromLot(String number) {
        if (VehicleParking.lots.contains(number)) {
            VehicleParking.lots.remove(number);
            System.out.println("You are unchecked from your place");
        } else {
            System.out.println("Sorry, you weren't checked. Maybe, it is not your Parking? ");
        }
    }

    private int getDuration() {
        if (dateOut.after(dateIn)) {
            duration = (int) ((dateOut.getTime() - dateIn.getTime())); // need add "/3600000" now without this, just for testing
            return duration;
        } else
            return 0;
    }

    private int getBill() {
        return this.pricePerHour * this.getDuration();
    }

    public void setVehicle(String owner, String number) {
        this.number = number;
        this.owner = owner;
        this.dateIn = new Date();
    }

    private boolean validateNumber() {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(this.number);
        if (m.matches()) {
            System.out.println("Hello, your vehicle is added");
            return true;
        } else
            System.out.println("Wrong format of vehicle number ");
        return false;
    }

    Date getDateIn() {
        return dateIn;
    }

    void setDateIn(Date dateIn) {
        this.dateIn = new Date();
    }

    Date getDateOut() {
        return this.dateOut;
    }

    String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return pricePerHour;
    }

    void setPrice(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    String getNumber() {
        return this.number;
    }

}
