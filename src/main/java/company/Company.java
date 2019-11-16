package company;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private List<Employee> employeeList;

    public Company(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void hireEmployee(Employee employee){
        if(employee.getIsHired()){
            this.employeeList.add(employee);
        }
    }

    public List<Employee> getEmployeesWithSalaryMoreThen(Integer salary) throws NoEmployeesHiredException {
        List<Employee> filtered = new ArrayList<>();
        if (this.employeeList.size()==0){
            throw new NoEmployeesHiredException("No one is hired - nothing to filter!");
        }
        for (Employee employee:this.employeeList) {
            if(employee.getSalary()>salary){
                filtered.add(employee);
            }
        }
        return filtered;
    }

    public void printEmployees(List<Employee> list) {
        System.out.printf("| %-12s | %s |\n", "Name", "Salary");
        System.out.println("-------------------------");
        for (Employee employee:list) {
            System.out.format("| %-12s | %-4d $ |", employee.getName(), employee.getSalary());
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
