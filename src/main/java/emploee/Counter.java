package emploee;

import java.util.Random;

public class Counter extends Emploee implements Workable {
    Counter(){}
    public Counter(String name, double salary){
        Random random = new Random(  ) ;
        this.name =name;
        this.salary =salary;
        isHire = random.nextBoolean();
    }
    public Counter(String name, double salary, boolean isHire){
        this.name =name;
        this.salary = salary;
        this.isHire = isHire;
    }

    public void doWork() {
        System.out.println("pay salary");
    }
}
