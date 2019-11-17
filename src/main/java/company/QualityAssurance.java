package company;

public class QualityAssurance extends Employee implements Workable {

    public QualityAssurance(String name, int salary, boolean isHired) {
        super(name, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println(String.format("I work in company as QualityAssurance"));
    }

}
