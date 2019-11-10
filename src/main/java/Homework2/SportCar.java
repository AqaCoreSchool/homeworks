package Homework2;

class SportCar extends Vehicle implements CanRunnig{

    String form = "Pick-up";
    Integer countOfWheels = 4;
    String speed = "fast";


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