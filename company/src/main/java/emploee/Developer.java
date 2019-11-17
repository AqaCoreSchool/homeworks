package emploee;

import java.util.Random;

public class Developer extends Director implements Workable{
    Developer(){}
    public Developer(String name, double salary){
        Random random = new Random(  ) ;
        this.name =name;
        this.salary =salary;
        isHire = random.nextBoolean();
    }
    public Developer(String name, double salary, boolean isHire){
        this.name =name;
        this.salary = salary;
        this.isHire = isHire;
    }
    public void doWork() {
        System.out.println("develop programs");
    }
}
