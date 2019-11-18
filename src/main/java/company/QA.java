package company;

import company.enums.EmployeeType;

public class QA extends AbstractEmployee implements Workable{

    private final String POSITION = EmployeeType.QA.toString();

    QA(String name, int salary) {
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
