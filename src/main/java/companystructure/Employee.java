package companystructure;

public abstract class Employee {
    String name;
    int salary;
    boolean hired;
    String position;

    Employee() {
        this.hired = isHired();
        Company.employeeList.add(Employee.this);
    }

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.position = getClass().getSimpleName();
        Company.employeeList.add(Employee.this);
    }

    boolean isHired() {
        return (Math.random() <= 0.5);
    }

    public void setHired(boolean hired) {
        this.hired = hired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
