package companystructure;

public class Developer extends Employee implements Workable {

    Developer() {
        super();
    }

    Developer(String name, int salary) {
        super(name, salary);
        this.hired = isHired();
    }

    @Override
    public void work() {
        System.out.println("Work as a " + getClass().getCanonicalName());
    }
}
