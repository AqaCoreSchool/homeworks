package ua.biz.test.enums;

public enum EmployeeColumnName {
    ID("employee_id"),
    NUMBER("emp_number"),
    FIRST_NAME("emp_firstname"),
    LAST_NAME("emp_lastname");

    private String name;

    EmployeeColumnName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
