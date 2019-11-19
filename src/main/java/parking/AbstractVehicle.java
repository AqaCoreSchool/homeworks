package parking;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static parking.VehicleParking.*;

public abstract class AbstractVehicle {
    private String owner;
    private String number;
    private String vehicleType;
    private Date dateIn;
    private Date dateOut;
    private int pricePerHour;
    private int bill;
    private int duration;
    private int lotNumber;

    public AbstractVehicle() {
        this.dateIn = new Date();
        this.dateOut = new Date();
    }

    public AbstractVehicle(String owner, String number) {
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

    public abstract void setDefaultValues();

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-15s%-10s%-20s%-10s%tc", this.vehicleType,  "Number:", this.number, "Owner:", this.owner, "Check in:", this.getDateIn());
    }

    public String toShortString() {

        return String.format("* %-10s * %s %s %s.  %s %-2tD %-2tR", this.number, this.vehicleType,
                "Owner:", this.owner, "Check in:", this.getDateIn(),this.getDateIn());
    }

    private void getTicket(){
        LocalDateTime timeInTicket = LocalDateTime.now();
        LocalDateTime finalTime = timeInTicket.plus(Duration.ofDays(1));
        String ticket = String.format("* %-10s * %s %tT. %s %-2tD %-2tR", this.getNumber(),
                                        "You were checked in", timeInTicket,
                                        "Your ticket is valid till", finalTime, finalTime);
        ticketsList.add(ticket);
    }

    public void checkIn(AbstractVehicle vehicle) {
        if (isNumberCorrect()) {
            if (freeLots > 0) { //// треба переробити
                Date dateIn = new Date();
                freeLots = freeLots - 1;
                assignCarToLot(this.number);
                vehicleList.add(vehicle);
                addCarToMap(vehicle.getNumber(), vehicle);
                getTicket();
            } else
                throw new ParkingLotNotFoundException("You can not add Vehicle, there are not available lots");
        }
    }

    private void assignCarToLot(String number) {            //переробити логіку
        if (VehicleParking.lotsList.size() < VehicleParking.LOT_COUNT) {
            VehicleParking.lotsList.add(number);
         //   System.out.println(number + " You have place №:" + (VehicleParking.lotsList.indexOf(number) + 1));
        } else {
            throw new ParkingLotNotFoundException("You can not add Vehicle, there are not available lots");
        }
    }

    public void checkOut(AbstractVehicle vehicle) {
        if ((freeLots < VehicleParking.LOT_COUNT) && (isCarInLot(this.number))) {
            freeLots = freeLots + 1;
            this.dateOut = new Date();
            vehicleList.remove(vehicle);
            numberVehicleMap.remove(this.number);
        } else
            System.out.println(number + " Oops, You aren't checked in. You need to do it!");
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
            duration = (int) (dateOut.getTime() - dateIn.getTime()); // need add "/3600000" now without this, just for testing
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

    private boolean isNumberCorrect() {
        try {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(this.number);
            if (m.matches()) {
                return true;
            } else {
                System.out.println(number + " - this is wrong format of vehicle number ");
                return false;
            }
        } catch (NullPointerException e) {
            System.out.println("Number is empty. You can not add vehicle without number ");
            return false;
        }
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
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getPrice() {
        return pricePerHour;
    }

    public void setPrice(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getNumber() {
        return this.number;
    }

}
