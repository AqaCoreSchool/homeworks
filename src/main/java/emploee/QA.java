package emploee;

import java.util.Random;

public class QA extends Emploee implements Workable {
    QA(){}
    public QA(String name, double salary){
        Random random = new Random(  ) ;
        this.name =name;
        this.salary =salary;
        isHire = random.nextBoolean();
    }
    public QA(String name, double salary, boolean isHire){
        this.name =name;
        this.salary = salary;
        this.isHire = isHire;
    }
    public void doWork() {
        System.out.println("prevent defect");
    }
}
