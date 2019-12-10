package com.company.sqlTest.data;

public class Employee {
    private String empNumber;
    private String firstName;
    private String lastName;
    private Vacancy vacancy;


    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public String toString() {
        return String.format("Employee [emp_number: %s| first_name: %s\t| last_name: %s| hiring_manager_id: %s| name=%s",
                empNumber, firstName, lastName, vacancy.getHrId(), vacancy.getName());
    }

}
