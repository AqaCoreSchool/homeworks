package company.employees;

import company.Post;
import company.Workable;


public class Employee implements Workable {

    private String name;
    private Post post;
    private int salary;
    private boolean isHired;

    public Employee() {
    }

    public Employee(String name, Post post, int salary, boolean isHired) {
        this.name = name;
        this.post = post;
        this.salary = salary;
        this.isHired = isHired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", post=" + post +
                ", salary=" + salary +
                ", isHired=" + isHired +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (salary != employee.salary) return false;
        if (isHired != employee.isHired) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return post == employee.post;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + (isHired ? 1 : 0);
        return result;
    }

    @Override
    public void work() {
        System.out.println("I am a worker");
    }
}
