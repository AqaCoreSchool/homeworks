package company;

import com.github.javafaker.Faker;
import company.employees.*;

import java.util.ArrayList;
import java.util.List;

public class Company  {

    private String name;
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }

    public List<Employee> getAllEmployees(){
        Faker faker= new Faker();
        List<Employee> employees = new ArrayList<>();

        employees.add(new Director(faker.name().firstName(), Post.DIRECTOR,
                faker.random().nextInt(5000, 8000), false));
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
            if(elem.getSalary() > salary) {
                filteredEmployees.add(elem);
            }
        }
        return  filteredEmployees;
    }

    public List<Employee> getHiredEmployees(List<Employee> employees){
        List<Employee> hiredEmployees = new ArrayList<>();
        for(Employee elem: employees){
            if(elem.isHired()) {
                hiredEmployees.add(elem);
            }
        }
        return hiredEmployees;
    }
}
