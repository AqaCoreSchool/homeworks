package company;

import company.enums.EmployeeType;

public class Developer extends AbstractEmployee implements Workable {

    private final String POSITION = EmployeeType.DEVELOPER.toString();

    Developer(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.printf("I am a %s.", POSITION);
    }

    public String getPosition() {
        return POSITION;
    }
}
