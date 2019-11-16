package company;

public abstract class Employee {
    private String name;
    private Integer salary;
    private boolean isHired;

    public Employee(String name, Integer salary, boolean isHired) {
        this.name = name;
        this.salary = salary;
        this.isHired = isHired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public boolean getIsHired() {
        return isHired;
    }

    public void setIsHired(boolean hired) {
        isHired = hired;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", isHired=" + isHired +
                '}';
    }

}
