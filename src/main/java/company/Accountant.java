package rybka.company;

public class Accountant extends Employee implements Workable {
    public Accountant(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println("Accountant is working");
    }
}
