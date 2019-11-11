package Homework2;

public class Owner extends Human implements CanDrink{
    String placeOfTheWorking = "Owner";
    Integer realSalary = 10000;
    String canDrinkTillDrunk = "Until can see other humans";



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
