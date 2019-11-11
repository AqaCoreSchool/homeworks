package com.company;

public class Admin extends Employees {

    public Admin() {
        Standard();
    }

    public Admin(String name, int workHours) {
        super(name, workHours);
        Standard();
    }

    @Override
    public void Standard() {
        this.setRatePerHour(100);
        this.setPosition("Admin");
    }

}
