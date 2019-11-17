package company;

public class Director extends Employee implements Workable {

    public Director(String name, int salary, boolean isHired) {
                super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println(String.format("I work in company as Director"));
    }
}
