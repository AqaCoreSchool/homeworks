
package parkinglot.vehicles;

import parkinglot.interfaces.Movable;

public class Lorry extends Vehicle implements Movable {


    private String stateNumber;
    private String form = "lorry";
    private int countOfWheels = 16;
    private int parkingPlace;
    private int stayOnParking;
    private String owner;

    public Lorry(String form, int countOfWheels, int parkingPlace, String stateNumber, int stayOnParking, String owner) {

        super(form, countOfWheels);
        this.parkingPlace = parkingPlace;
        this.stateNumber = stateNumber;
        this.stayOnParking = stayOnParking;
        this.owner = owner;

    }


    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getCountOfWheels() {
        return countOfWheels;
    }

    public void setCountOfWheels(int countOfWheels) {
        this.countOfWheels = countOfWheels;
    }


    public int getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(int parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public String getStateNumber() {
        return stateNumber;
    }


    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public int getStayOnParking() {
        return stayOnParking;
    }

    public void setStayOnParking(int stayOnParking) {
        this.stayOnParking = stayOnParking;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String move() {
        return "slow";
    }
}
