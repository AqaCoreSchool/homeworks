package company.enums;

import com.github.javafaker.Faker;
import company.interfaces.Workable;

public enum Employee implements Workable {
    DIRECTOR(){
        @Override
        public void work() {
            System.out.println("I work as a Director.");
        }
    },
    QA(){
        @Override
        public void work() {
            System.out.println("I work as a QA.");
        }
    },
    DEVELOPER(){
        @Override
        public void work() {
            System.out.println("I work as a Developer.");
        }
    },
    MANAGER(){
        @Override
        public void work() {
            System.out.println("I work as a Manager.");
        }
    },
    ACCOUNTANT(){
        @Override
        public void work() {
            System.out.println("I work as a Accountant.");
        }
    };

    private String name;
    private double salary;
    private boolean isHired;
    Faker faker = new Faker();


    public String getName() {
        return faker.name().fullName();
    }

    public double getSalary() {
        return (faker.random().nextDouble()) * 100000;
    }

    public boolean isHired() {
        return faker.random().nextBoolean();
    }
}
