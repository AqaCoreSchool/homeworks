package company;

public class Accountant extends Employee implements Workable{

    private String name;
    private Integer salary;
    private boolean isHired;

    public Accountant(String name, Integer salary, boolean isHired) {
        super(name, salary, isHired);
    }


    @Override
    public void work() {
        System.out.println("I'm counting salaries...");
    }
}
