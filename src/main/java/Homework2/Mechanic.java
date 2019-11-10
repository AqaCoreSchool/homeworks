package Homework2;

public class Mechanic extends Human implements CanDrink{
    String placeOfTheWorking = "Mechanic";
    Integer realSalary = 500;
    String canDrinkTillDrunk = "Until can see the wheels";




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
