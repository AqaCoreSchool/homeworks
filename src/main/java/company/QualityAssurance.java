package rybka.company;

public class QualityAssurance extends Employee implements Workable {
    public QualityAssurance(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println("QA is working");
    }
}
