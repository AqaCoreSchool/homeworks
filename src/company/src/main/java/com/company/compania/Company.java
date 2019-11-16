package com.company.compania;

import com.company.compania.positions.*;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> workers;
    Faker faker = new Faker();

    Company() {
        workers = new ArrayList<>();

            workers.add(new Director("O. Bilynska", 50000, true));
            workers.add(new Director("M. Vankovych", 30000, true));
            workers.add(new Director("V. Muchka", 35000, true));

            workers.add(new Manager("I. Romanych", 20000, faker.random().nextBoolean()));
            workers.add(new Manager("L. Martyn", 20000, faker.random().nextBoolean()));
            workers.add(new Manager("P. Hural", 10000, faker.random().nextBoolean()));
            workers.add(new Manager("J. Pib", 20000, faker.random().nextBoolean()));

            workers.add(new Dev("G. Sirko", 40000, faker.random().nextBoolean()));
            workers.add(new Dev("Y. Ris", 35000, faker.random().nextBoolean()));

            workers.add(new QA("R. Bronte", 19000, faker.random().nextBoolean()));
            workers.add(new QA("S. Kilometr", 21000, faker.random().nextBoolean()));
            workers.add(new QA("K. Bilyk", 10000, faker.random().nextBoolean()));

            workers.add(new Accountant("I. Kogut", 9000, faker.random().nextBoolean()));
            workers.add(new Accountant("A. Vyluk", 10000, faker.random().nextBoolean()));
            workers.add(new Accountant("T. Rondo", 5000, faker.random().nextBoolean()));
    }

    //1
    void getEmployeesWithSalary(int salary) {
        List<Employee> listOfSalary = new ArrayList<>();
        for (Employee person : workers) {
            if (person.getEmployeeSalary() > salary) {
                listOfSalary.add(person);
            }
        }
        for (int i = 0; i < listOfSalary.size(); i++) {
            System.out.println(String.format("%25s", listOfSalary.get(i)));
        }
    }

    //2
    void getEmployeesNames() {
        List<String> listOfNames = new ArrayList<>();
        for (Employee person : workers) {
            listOfNames.add(person.getEmployeeName());
        }
        for (int i = 0; i < listOfNames.size(); i++) {
            System.out.println(String.format("|%3d| %15s|", i+1, listOfNames.get(i)));
        }
    }

    //3
    void getHired(){
        List<String> listOfHired = new ArrayList<>();
        for (Employee person : workers){
            if(person.isEmployeeHired()){
                listOfHired.add(person.getEmployeeName());
            }
        }
        for (int i = 0; i < listOfHired.size(); i++) {
            System.out.println(String.format("|%15s|", listOfHired.get(i)));
        }
    }
}
