package employee;

import work.Workable;

public class Qa extends Employee implements Workable {
    public Qa(String name, double salary,boolean isHired){
        super(name,salary,isHired);
    }
    public void work() {
        System.out.println("You are good tester (joke) ");
    }
}
