package company.employees;

import company.Post;
import company.Workable;

public class QualityAssurance extends Employee implements Workable {

    public QualityAssurance(String name, Post post, int salary, boolean isHired) {
        super(name, post, salary, isHired);
    }

    @Override
    public void work() {
        System.out.println("I am a QA");
    }
}
