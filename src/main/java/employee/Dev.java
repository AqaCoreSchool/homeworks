package employee;

import work.Workable;

public class Dev extends Employee implements Workable {
    public Dev(String name, double salary,boolean isHired){
        super(name, salary, isHired);
    }

    public void work() {
        System.out.println("You are good developer (joke) ");
    }
}
