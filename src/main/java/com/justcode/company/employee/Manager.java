package com.justcode.company.employee;

public class Manager extends Employee implements Workable {

    public Manager(String name, double salary, boolean isHired) {
        super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println("Manages projects");
    }
}
