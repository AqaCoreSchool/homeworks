package employee;

import work.Workable;

public class Manager extends Employee implements Workable {
    public Manager(String name, double salary,boolean isHired){
        super(name,salary,isHired);
    }
    public void work() {
        System.out.println("Manager works");
    }
}
