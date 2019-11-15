package rybka.company;

public class Director extends Employee implements Workable {
    public Director(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println("Director is working");
    }
}
