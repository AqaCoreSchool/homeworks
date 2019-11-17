package com.company.compania;

import com.company.compania.positions.QA;
import com.company.compania.positions.Dev;
import com.company.compania.positions.Manager;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Faker faker = new Faker();
            Company coreValue = new Company();

            System.out.println("Enter salary, please ->");
            Scanner myInput = new Scanner(System.in);
            int inpSalary = myInput.nextInt();
            coreValue.getEmployeesWithSalary(inpSalary);

            System.out.println("All Employees:");
            coreValue.getEmployeesNames();

            System.out.println("\nAll which Hired:");
            coreValue.getHired();

            QA qaWorker = new QA("QA", 40000, faker.random().nextBoolean());
            qaWorker.work();
            Dev devWorker = new Dev("Developer", 12000, faker.random().nextBoolean());
            devWorker.work();
            Manager managerWorker = new Manager("Manager", 45454, faker.random().nextBoolean());
            managerWorker.work();

    }
}




