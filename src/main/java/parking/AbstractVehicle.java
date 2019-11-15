package parking;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static parking.VehicleParking.*;

abstract public class AbstractVehicle {
    private String owner;
    private String number;
    private String vehicleType;
    private Date dateIn;
    private Date dateOut;
    private int pricePerHour;
    private int bill;
    private int duration;
    private int lotNumber;

    AbstractVehicle() {
        this.dateIn = new Date();
        this.dateOut = new Date();
    }

    AbstractVehicle(String owner, String number) {
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
        return this.vehicleType + " number: " + this.number + ". Owner: " + this.owner + ". Check in: " + this.getDateIn(); //
    }


    void checkIn(AbstractVehicle vehicle) {
        if (validateNumber()) {
            if (freeLots > 0) { //// треба переробити
                Date dateIn = new Date();
                freeLots = freeLots - 1;
                assignCarToLot(this.number);
                vehicleList.add(vehicle);
                addCarToMap(vehicle.getNumber(), vehicle);
            } else
                System.out.println("There aren't available lots");
        }
    }

    void checkOut(AbstractVehicle vehicle) {
        if ((freeLots < VehicleParking.LOT_COUNT) && (isCarInLot(this.number))) {
            freeLots = freeLots + 1;
            this.dateOut = new Date();
            vehicleList.remove(vehicle);
            numberVehicleMap.remove(this.number);
        } else
            System.out.println(number + " Oops, You aren't checked in. You need to do it!");
    }

    private void assignCarToLot(String number) {
        if ((VehicleParking.lotsList.size() < VehicleParking.LOT_COUNT)) {
            VehicleParking.lotsList.add(number);
            System.out.println(number + " You have place №:" + (VehicleParking.lotsList.indexOf(number) + 1));
        } else {
            System.out.println("Sorry, there's no lots available.");
        }
    }

    private boolean isCarInLot(String number) {
        if (lotsList.contains(number)) {
            lotsList.remove(number);
            System.out.println(number + " You are unchecked from your place");
            return true;
        } else
            return false;
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
            return true;
        } else
            System.out.println(number + " Wrong format of vehicle number ");
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

    String getVehicleType() {
        return vehicleType;
    }

    void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
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
