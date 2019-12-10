package com.company.sqlTest.data;

public class Vacancy {
    private String hrId;
    private String name;
    Employee employee;

    public void setHrId(String hrId) {
        this.hrId = hrId;
    }

    public String getHrId() {
        return hrId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return String.format("Vacancy [hiring_manager_id: %s| name: %s|\t emp_number: %s| first_name: %s| last_name: %s]",
                hrId, name, employee.getEmpNumber(), employee.getFirstName(), employee.getLastName());
    }
}
