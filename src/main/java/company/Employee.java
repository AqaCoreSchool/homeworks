package company;

/**
 * Represents an abstraction for each {@link company.model} class.
 *
 * @author  Pavlo Hrytsyshyn
 * @version 1.0
 * @since   2019-11-15
 */
public abstract class Employee {
    private String name;
    private int salary;
    private boolean isHired;

    public Employee(String name, int salary, boolean isHired) {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }
}
