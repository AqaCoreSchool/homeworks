package company;

public class Manager extends Employee implements Workable {

    public Manager(String name, int salary, boolean isHired) {
        super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println(String.format("I work in company as Manager"));
    }
}
