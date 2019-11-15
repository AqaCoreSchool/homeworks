package rybka.company;

public class Developer extends Employee implements Workable {
    public Developer(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println("Developer is working");
    }
}
