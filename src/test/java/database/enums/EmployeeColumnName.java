package database.enums;

public enum EmployeeColumnName {
    ID("emp_number"),
    FIRST_NAME("emp_firstname"),
    LAST_NAME("emp_lastname");

    private final String name;

    EmployeeColumnName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
