package company;


public class Dev extends Employee implements Workable {

    public Dev(String name, int salary, boolean isHired) {
        super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println(String.format("I work in company as Developer"));
    }
}

