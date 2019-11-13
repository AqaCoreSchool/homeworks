package parkinglot;

public class Owner extends Human implements CanDrink{
    String placeOfTheWorking = "Owner";
    int realSalary = 10000;
    String canDrinkTillDrunk = "Until can see other humans";



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
