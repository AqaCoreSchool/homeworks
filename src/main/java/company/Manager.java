package company;

import company.enums.EmployeeType;

public class Manager extends AbstractEmployee implements Workable {

    private final String POSITION = EmployeeType.MANAGER.toString();

    Manager(String name, int salary) {
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
