package com.justcode.company.employee;

public class QualityAssuranceEngineer extends Employee implements Workable {

    public QualityAssuranceEngineer(String name, double salary, boolean isHired) {
        super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println("Checks projects");
    }
}
