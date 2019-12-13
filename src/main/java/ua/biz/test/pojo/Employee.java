package ua.biz.test.pojo;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String number;
    private String firstName;
    private String lastName;
    private List<JobVacancy> vacancies;

    public Employee() {
        vacancies = new ArrayList<>();
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setVacancies(JobVacancy vacancy) {
        vacancies.add(vacancy);
    }

    public String getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<JobVacancy> getVacancies() {
        return vacancies;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "number='" + number + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", vacancies=" + vacancies +
                '}';
    }
}
