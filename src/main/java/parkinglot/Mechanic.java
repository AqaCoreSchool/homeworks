package parkinglot;

public class Mechanic extends Human implements CanDrink{
    String placeOfTheWorking = "Mechanic";
    int realSalary = 500;
    String canDrinkTillDrunk = "Until can see the wheels";




    @Override
    public String workingPlace() {
        return placeOfTheWorking;
    }

    @Override
    public Integer salary() {
        return realSalary;
    }

    @Override
    public String howCanDrinkHuman() {
        return canDrinkTillDrunk;
    }
}
