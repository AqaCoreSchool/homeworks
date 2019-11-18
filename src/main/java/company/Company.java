package company;

import com.github.javafaker.Faker;
import employee.*;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private  Employee employee;
    private List<Employee> employeesList = new ArrayList<Employee>();
    Faker faker = new Faker();
    public Company(){
        getEmployeesList().add(new Director(faker.name().lastName(),faker.random().nextInt(0,10000),true));
        getEmployeesList().add(new Qa(faker.name().lastName(),faker.random().nextInt(0,10000),faker.random().nextBoolean()));
        getEmployeesList().add(new Qa(faker.name().lastName(),faker.random().nextInt(0,10000),faker.random().nextBoolean()));
        getEmployeesList().add(new Qa(faker.name().lastName(),faker.random().nextInt(0,10000),faker.random().nextBoolean()));
        getEmployeesList().add(new Dev(faker.name().lastName(),faker.random().nextInt(0,10000),faker.random().nextBoolean()));
        getEmployeesList().add(new Dev(faker.name().lastName(),faker.random().nextInt(0,10000),faker.random().nextBoolean()));
        getEmployeesList().add(new Dev(faker.name().lastName(),faker.random().nextInt(0,10000),faker.random().nextBoolean()));
        getEmployeesList().add(new Dev(faker.name().lastName(),faker.random().nextInt(0,10000),faker.random().nextBoolean()));
        getEmployeesList().add(new Manager(faker.name().lastName(),faker.random().nextInt(0,10000),faker.random().nextBoolean()));
    }
    public List getEmployeesWithSalaryMoreThan(int salary) {
        List<Employee>listMoreSalary = new ArrayList<Employee>();
        for(Employee employee : employeesList) {
            if (employee.getSalary() >= salary) {
                listMoreSalary.add(employee);
            }
        }
        return listMoreSalary;
    }

    public void printEmployees(List<Employee>employeesList) {
        for (Employee employee : employeesList) {
            System.out.println("Name " + " Salary " + " isHired");
            System.out.println((employee.getName() + " " + employee.getSalary() + " "
                    + employee.isHired()));
        }
    }
        public List isRealWorker(List<Employee>employeesList){
            List<Employee>hiredEmployeeList = new ArrayList<Employee>();
            for (Employee employee : employeesList) {
                if (employee.isHired()) {
                    hiredEmployeeList.add(employee);
                }
            }
                    return hiredEmployeeList;
            }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }
}

