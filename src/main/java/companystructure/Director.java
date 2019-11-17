package companystructure;

public class Director extends Employee implements Workable {

    Director(String name, int salary) {
        super(name, salary);
        this.hired = true;
    }

    Director() {
        super();
    }

    @Override
    public void work() {
        System.out.println("Work as a " + getClass().getCanonicalName());
    }
}
