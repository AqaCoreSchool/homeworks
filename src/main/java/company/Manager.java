package company;

public class Manager extends Employee implements Workable{

    private String name;
    private Integer salary;
    private boolean isHired;

    public Manager(String name, Integer salary, boolean isHired) {
        super(name, salary, isHired);
    }


    @Override
    public void work() {
        System.out.println("I'm managing dev and QA teams...");
    }
}
