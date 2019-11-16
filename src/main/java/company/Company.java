package company;

import company.entity.ModelEmployee;
import company.factory.EmployeeFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static company.enums.Employee.*;

public class Company  {
    List<ModelEmployee> employeeList = new ArrayList<>();

    public List<ModelEmployee> getDefaultList(){
        employeeList.addAll(Arrays.asList(EmployeeFactory.buildEmployee(DIRECTOR),
                EmployeeFactory.buildEmployee(DIRECTOR),
                EmployeeFactory.buildEmployee(DEVELOPER),
                EmployeeFactory.buildEmployee(DEVELOPER),
                EmployeeFactory.buildEmployee(DEVELOPER),
                EmployeeFactory.buildEmployee(DEVELOPER),
                EmployeeFactory.buildEmployee(DEVELOPER),
                EmployeeFactory.buildEmployee(QA),
                EmployeeFactory.buildEmployee(QA),
                EmployeeFactory.buildEmployee(QA),
                EmployeeFactory.buildEmployee(MANAGER),
                EmployeeFactory.buildEmployee(MANAGER),
                EmployeeFactory.buildEmployee(MANAGER),
                EmployeeFactory.buildEmployee(ACCOUNTANT),
                EmployeeFactory.buildEmployee(ACCOUNTANT),
                EmployeeFactory.buildEmployee(ACCOUNTANT)));
        return  employeeList;
    }

    public void  getList(List<ModelEmployee> list){
        if(list.isEmpty()){
            throw new IllegalStateException("The company has no employees.");
        }
        System.out.println("Name \t\t\t\t Salary \t\t\t\t isHired");
        for (ModelEmployee employee : list){
            System.out.println(employee.getName()+"\t\t\t"+employee.getSalary()+"\t\t\t"+employee.isHired());
        }
    }

    public List<ModelEmployee> getEmployeeWithSalary(double salary){
        List<ModelEmployee> employeeList2 = new ArrayList<>();
        for (ModelEmployee employee: employeeList){
            if(employee.getSalary() >= salary){
                employeeList2.add(employee);
            }
        }
        if(employeeList2.isEmpty()){
            throw new IllegalStateException("The company does not have such salaries.");
        }
        return employeeList2;
    }

    public void  getListName(List<ModelEmployee> list){
        for (ModelEmployee employee : list){
            System.out.println(employee.getName());
        }
    }

    public List<ModelEmployee> getEmployeeIsHired(){
        List<ModelEmployee> employeeList2 = new ArrayList<>();
        for (ModelEmployee employee: employeeList){
            if(employee.isHired() == true){
                employeeList2.add(employee);
            }
        }
        if(employeeList2.isEmpty()){
            throw new IllegalStateException("The company has no employees.");
        }
        return employeeList2;
    }
}
