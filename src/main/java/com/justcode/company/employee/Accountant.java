package com.justcode.company.employee;

public class Accountant extends Employee implements Workable{

    public Accountant(String name, double salary, boolean isHired) {
        super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println("Calculates employee salaries");
    }
}
