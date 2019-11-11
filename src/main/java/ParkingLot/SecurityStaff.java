package com.company;

public class SecurityStaff extends Employees {

    public SecurityStaff() {
        Standard();
    }

    public SecurityStaff(String name, int workHours) {
        super(name, workHours);
        Standard();
    }

    @Override
    public void Standard() {
        this.setPosition("Security");
        this.setRatePerHour(40);
    }

}
