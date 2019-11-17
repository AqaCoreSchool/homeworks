package company;

public class Accountant extends Employee implements Workable {

    public Accountant(String name, int salary, boolean isHired) {
        super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println(String.format("I work in company as Accountant"));
    }
}

