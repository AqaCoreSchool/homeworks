package company.employees;

import com.github.javafaker.Faker;
import company.Post;
import company.Workable;

import java.util.ArrayList;
import java.util.List;

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


    public List<Employee> getAllEmployees(){
        Faker faker= new Faker();
        List<Employee> employees = new ArrayList<>();

        employees.add(new Director(faker.name().firstName(), Post.DIRECTOR,
                faker.random().nextInt(5000, 8000), true));
        employees.add(new Accountant(faker.name().firstName(), Post.ACCOUNTANT,
                faker.random().nextInt(1000, 2500), faker.random().nextBoolean()));
        employees.add(new Accountant(faker.name().firstName(), Post.ACCOUNTANT,
                faker.random().nextInt(1000, 2500), faker.random().nextBoolean()));
        employees.add(new Developer(faker.name().firstName(), Post.DEVELOPER,
                faker.random().nextInt(3000, 5000), faker.random().nextBoolean()));
        employees.add(new QualityAssurance(faker.name().firstName(), Post.QUALITY_ASSURANCE,
                faker.random().nextInt(600, 2000), faker.random().nextBoolean()));
        employees.add(new QualityAssurance(faker.name().firstName(), Post.QUALITY_ASSURANCE,
                faker.random().nextInt(600, 2000), faker.random().nextBoolean()));
        employees.add(new Manager(faker.name().firstName(), Post.MANAGER,
                faker.random().nextInt(900, 1700), faker.random().nextBoolean()));
        employees.add(new Developer(faker.name().firstName(), Post.DEVELOPER,
                faker.random().nextInt(3000, 5000), faker.random().nextBoolean()));
        employees.add(new QualityAssurance(faker.name().firstName(), Post.QUALITY_ASSURANCE,
                faker.random().nextInt(600, 2000), faker.random().nextBoolean()));
        employees.add(new QualityAssurance(faker.name().firstName(), Post.QUALITY_ASSURANCE,
                faker.random().nextInt(600, 2000), faker.random().nextBoolean()));
        employees.add(new Manager(faker.name().firstName(), Post.MANAGER,
                faker.random().nextInt(900, 1700), faker.random().nextBoolean()));

        return employees;
    }


    public void printEmployeeNames(List<Employee> employees){

        for(Employee elem: employees){
            System.out.printf(" *%s is our %s* %n", elem.getName(),
                    elem.getPost().toString().toLowerCase().replace('_', ' '));
        }
    }

    public List<Employee> getEmployeesWithSalaryMoreThan(List<Employee> employees, int salary){
        List<Employee> filteredEmployees = new ArrayList<>();
        for(Employee elem: employees){
            if(elem.salary > salary) {
                filteredEmployees.add(elem);
            }
        }
        return  filteredEmployees;
    }

    public List<Employee> getHiredEmployees(List<Employee> employees, boolean isHired){
        List<Employee> hiredEmployees = new ArrayList<>();
        for(Employee elem: employees){
            if(elem.isHired == isHired) {
                hiredEmployees.add(elem);
            }
        }
        return hiredEmployees;
    }
}
