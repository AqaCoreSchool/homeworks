package company;

public class Developer extends Employee implements Workable{

    private String name;
    private Integer salary;
    private boolean isHired;

    public Developer(String name, Integer salary, boolean isHired) {
        super(name, salary, isHired);
    }


    @Override
    public void work() {
        System.out.println("I'm coding new features...");
    }
}
