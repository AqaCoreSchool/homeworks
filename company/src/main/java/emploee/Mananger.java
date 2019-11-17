package emploee;

import java.util.Random;

public class Mananger extends Emploee implements Workable{
    Mananger(){}
    public Mananger(String name, double salary){
        Random random = new Random(  ) ;
        this.name =name;
        this.salary =salary;
        isHire = random.nextBoolean();
    }
    public Mananger(String name, double salary, boolean isHire){
        this.name =name;
        this.salary = salary;
        this.isHire = isHire;
    }
    public void doWork() {
        System.out.println("organise work");
    }
}
