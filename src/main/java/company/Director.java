package company;

public class Director extends Employee implements Workable{

    private String name;
    private Integer salary;
    private boolean isHired;

    public Director(String name, Integer salary, boolean isHired) {
        super(name, salary, isHired);
    }


    @Override
    public void work() {
        System.out.println("I'm in charge of this company...");
    }
}
