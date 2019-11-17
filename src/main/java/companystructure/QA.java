package companystructure;

public class QA extends Employee implements Workable {

    QA() {
        super();
    }

    QA(String name, int salary) {
        super(name, salary);
        this.hired = isHired();
    }

    @Override
    public void work() {
        System.out.println("Work as a " + getClass().getCanonicalName());
    }
}
