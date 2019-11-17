package companystructure;

public class Accountant extends Employee implements Workable {
    Accountant() {
        super();
    }

    Accountant(String name, int salary) {
        super(name, salary);
        this.hired = isHired();
    }

    @Override
    public void work() {
        System.out.println("Work as a " + getClass().getCanonicalName());
    }
}
