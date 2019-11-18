package company;

public class QA extends Employee implements Workable{

    private String name;
    private Integer salary;
    private boolean isHired;

    public QA(String name, Integer salary, boolean isHired) {
        super(name, salary, isHired);
    }


    @Override
    public void work() {
        System.out.println("I'm testing new features...");
    }
}
