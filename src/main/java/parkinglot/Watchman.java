package parkinglot;

public class Watchman extends Human implements CanDrink{
    String placeOfTheWorking = "Watchman";
    Integer realSalary = 200;
    String canDrinkTillDrunk = "Until down to the ground";



    @Override
    String workingPlace() {
        return placeOfTheWorking;
    }

    @Override
    Integer salary() {
        return realSalary;
    }

    @Override
    public String howCanDrinkHuman() {
        return canDrinkTillDrunk;
    }
}
