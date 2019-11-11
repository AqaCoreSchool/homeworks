package Homework2;

public class Lorry extends Vehicle implements CanRunnig{


    private String form = "be-eg";
    private Integer countOfWheels = 16;
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
