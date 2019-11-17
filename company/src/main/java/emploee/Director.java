package emploee;

import java.util.Random;

public class Director extends Emploee implements Workable {
    Director(){}
    public Director(String name, double salary){
        Random random = new Random(  ) ;
        this.name =name;
        this.salary =salary;
        isHire = random.nextBoolean();
    }
    public Director(String name, double salary, boolean isHire){
        this.name =name;
        this.salary = salary;
        this.isHire = isHire;
    }
    public void doWork() {
        System.out.println("give work");

    }
}
