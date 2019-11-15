package rybka.company;

public class Manager extends Employee implements Workable {
    public Manager(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println("Manager is working");
    }
}
