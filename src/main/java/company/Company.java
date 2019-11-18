package company;

import company.enums.EmployeeType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Company {

    private List<AbstractEmployee> employees;
    private String name;

    Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
        System.out.printf("Company %s has been founded.\n", getName());
    }

    public String getName() {
        return name;
    }

    public void addEmployee(AbstractEmployee employee) {
        if (employee instanceof Director) {
            System.out.printf("New %s %s has been hired.\n", employee.getPosition(), employee.getName());
            employees.add(employee);
        } else if (isHired(employee)) {
            System.out.printf("New %s %s has been hired.\n", employee.getPosition(), employee.getName());
            employees.add(employee);
        } else {
            System.out.printf("New %s %s has not been hired.\n", employee.getPosition(), employee.getName());
        }
    }

    private boolean isHired(AbstractEmployee employee) {
        // method which randomly returns true or false for each employee except director
        if (employee instanceof Director) {
            return true;
        } else {
            return Math.random() < 0.5;
        }
    }

    public void removeEmployee(AbstractEmployee employee) {
        employees.remove(employee);
    }

    public List<AbstractEmployee> getEmployeesListBySalaryMoreThan(int salaryToCompare) {

        List<AbstractEmployee> filteredEmployeesList = new ArrayList<>();

        Iterator iterator = employees.iterator();
        AbstractEmployee employee;

        while (iterator.hasNext()) {
            employee = (AbstractEmployee) iterator.next();
            if (employee.getSalary() > salaryToCompare) {
                filteredEmployeesList.add(employee);
            }
        }
        return filteredEmployeesList;
    }

    public void printEmployees() {

        Iterator iterator = employees.iterator();
        AbstractEmployee employee;
        StringBuilder lineFiller = new StringBuilder();

        int maxLengthOfEmployeesPositions = getMaxLengthOfEmployeesPositions();
        int maxLengthOfEmployeesNames = getMaxLengthOfEmployeesNames();
        int maxLengthOfEmployeesSalaries = getMaxLengthOfEmployeesSalaries();

        String positionStr = "Position";
        String nameStr = "Name";
        String salaryStr = "Salary";

        int strLength = 10; // for better formatting

        strLength += Math.max(maxLengthOfEmployeesPositions, positionStr.length()) +
                Math.max(maxLengthOfEmployeesNames, nameStr.length()) +
                Math.max(maxLengthOfEmployeesSalaries, salaryStr.length());

        //String lineFiller = "";

        for (int i = 0; i < strLength; i++)
            lineFiller.append("-");

        String formatter = "| %" +
                Integer.toString(Math.max(maxLengthOfEmployeesPositions, positionStr.length())) +
                "s | %" +
                Integer.toString(Math.max(maxLengthOfEmployeesNames, nameStr.length())) +
                "s | %" +
                Integer.toString(Math.max(maxLengthOfEmployeesSalaries, salaryStr.length())) +
                "s |\n";

        System.out.println(lineFiller);

        System.out.printf(formatter, positionStr, nameStr, salaryStr);

        System.out.println(lineFiller);

        while (iterator.hasNext()) {

            employee = (AbstractEmployee) iterator.next();

            System.out.printf(formatter,
                    employee.getPosition(),
                    employee.getName(),
                    employee.getSalary());

            System.out.println(lineFiller);
        }
    }

    public void printFilteredEmployees(List<AbstractEmployee> employees) {

        Iterator iterator = employees.iterator();
        AbstractEmployee employee;
        StringBuilder lineFiller = new StringBuilder();

        int maxLengthOfEmployeesPositions = getMaxLengthOfEmployeesPositions();
        int maxLengthOfEmployeesNames = getMaxLengthOfEmployeesNames();
        int maxLengthOfEmployeesSalaries = getMaxLengthOfEmployeesSalaries();

        String positionStr = "Position";
        String nameStr = "Name";
        String salaryStr = "Salary";

        int strLength = 10; // for better formatting

        strLength += Math.max(maxLengthOfEmployeesPositions, positionStr.length()) +
                Math.max(maxLengthOfEmployeesNames, nameStr.length()) +
                Math.max(maxLengthOfEmployeesSalaries, salaryStr.length());

        for (int i = 0; i < strLength; i++)
            lineFiller.append("-");

        String formatter = "| %" +
                Integer.toString(Math.max(maxLengthOfEmployeesPositions, positionStr.length())) +
                "s | %" +
                Integer.toString(Math.max(maxLengthOfEmployeesNames, nameStr.length())) +
                "s | %" +
                Integer.toString(Math.max(maxLengthOfEmployeesSalaries, salaryStr.length())) +
                "s |\n";

        System.out.println(lineFiller);

        System.out.printf(formatter, positionStr, nameStr, salaryStr);

        System.out.println(lineFiller);

        while (iterator.hasNext()) {
            employee = (AbstractEmployee) iterator.next();
            System.out.printf(formatter, employee.getPosition(),
                    employee.getName(), employee.getSalary());

            System.out.println(lineFiller);
        }
    }

    // for printing in the table
    private int getMaxLengthOfEmployeesNames() {

        Iterator iterator = employees.iterator();
        int maxLength = 0;
        int currentLength;
        AbstractEmployee employee;

        while (iterator.hasNext()) {
            employee = (AbstractEmployee) iterator.next();
            currentLength = employee.getName().length();

            if (maxLength < currentLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }

    private int getMaxLengthOfEmployeesPositions() {

        Iterator iterator = employees.iterator();
        int maxLength = 0;
        int currentLength;
        AbstractEmployee employee;

        while (iterator.hasNext()) {
            employee = (AbstractEmployee) iterator.next();
            currentLength = employee.getPosition().length();

            if (maxLength < currentLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }

    private int getMaxLengthOfEmployeesSalaries() {

        Iterator iterator = employees.iterator();
        int maxLength = 0;
        int currentLenght;
        AbstractEmployee employee;

        while (iterator.hasNext()) {
            employee = (AbstractEmployee) iterator.next();
            currentLenght = Integer.toString(employee.getSalary()).length();

            if (maxLength < currentLenght) {
                maxLength = currentLenght;
            }
        }
        return maxLength;
    }
}
