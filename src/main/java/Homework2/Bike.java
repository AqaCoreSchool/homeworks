package Homework2;

public class Bike extends Vehicle implements CanRunnig {
    private String form = "Bike";
    private Integer countOfWheels = 2;
    String speed = "normal";


    @Override
    String body() {
        return form;
    }

    @Override
    Integer wheels() {
        return countOfWheels;
    }

    @Override
    public String howCanRunVehicle() {
        return speed;
    }
}
