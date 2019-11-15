package com.justcode.company.employee;

public class Director extends Employee implements Workable {

    public Director(String name, double salary, boolean isHired) {
        super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println("Manages the com.justcode.company");
    }
}
