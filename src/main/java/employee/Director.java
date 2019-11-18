package employee;

import work.Workable;

public class Director extends Employee implements Workable {
    public Director(String name, double salary,boolean isHired){
        super(name, salary, isHired=true);
    }
    public void work() {
        System.out.println("Director sleeps");
    }
}
