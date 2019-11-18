package employee;

public abstract class Employee {
    private String name;
    private double salary;
    private boolean isHired;

    public Employee(String name, double salary, boolean isHired){
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }

    @Override
    public String toString(){
        return "Name: '" + this.name +
                "',Salary: '" + this.salary +
                "', IsHired: '" + this.isHired + "'";
    }
}
