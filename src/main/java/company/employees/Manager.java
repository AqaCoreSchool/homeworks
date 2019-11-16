package company.employees;

import company.Post;
import company.Workable;
import company.employees.Employee;

public class Manager extends Employee implements Workable {

    public Manager(String name, Post post, int salary, boolean isHired) {
        super(name, post, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println("I am a manager");
    }
}
