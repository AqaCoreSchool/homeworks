package company.factory;

import company.enums.Employee;
import company.entity.ModelEmployee;

public class EmployeeFactory {

    public static ModelEmployee buildEmployee(Employee employee){
        return ModelEmployee.builder()
                .name(employee.getName())
                .salary(employee.getSalary())
                .isHired(employee.isHired())
                .build();
    }
}
