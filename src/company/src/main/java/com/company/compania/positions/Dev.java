package com.company.compania.positions;

import com.company.compania.Employee;
import com.company.compania.interfaces.Workable;
import com.github.javafaker.Faker;

public class Dev extends Employee implements Workable {


    public Dev(String name, int salary, boolean ishired) {
        super(name, salary, ishired);
    }

    @Override
    public void work() {
        String position = getClass().toString().substring(37);
        System.out.println(String.format("I work in company as <%s>", position));
    }
}
