package com.justcode.company.employee;

public class Developer extends Employee implements Workable {

    public Developer(String name, double salary, boolean isHired) {
        super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println("Develops software");
    }
}
