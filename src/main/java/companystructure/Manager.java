package companystructure;

public class Manager extends Employee implements Workable {
    Manager() {
    }

    Manager(String name, int salary) {
        super(name, salary);
        this.hired = isHired();
    }

    @Override
    public void work() {
        System.out.println("Work as a " + getClass().getCanonicalName());
    }
}
