package company;

import com.github.javafaker.Faker;
import company.exception.EmployeeNotFoundException;
import company.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a company {@link Employee} hiring process.
 *
 * @author  Pavlo Hrytsyshyn
 * @version 1.0
 * @since   2019-11-15
 */
public class Company {
    private List<Employee> employeeList = new ArrayList<>();
    private List<Employee> candidateList = new ArrayList<>();
    private List<Employee> filteredEmployeeList = new ArrayList<>();

    /**
     * Fills {@link Company#getCandidateList()} with random data of {@link Employee}
     */
    public Company() {
        Faker faker = new Faker();
        candidateList.add(new QA(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new QA(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new QA(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new QA(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));

        candidateList.add(new Director(faker.name().firstName(), faker.random().nextInt(500, 3000),true));
        candidateList.add(new Director(faker.name().firstName(), faker.random().nextInt(500, 3000),true));
        candidateList.add(new Director(faker.name().firstName(), faker.random().nextInt(500, 3000),true));

        candidateList.add(new Developer(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new Developer(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new Developer(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new Developer(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));

        candidateList.add(new Manager(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new Manager(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new Manager(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new Manager(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));

        candidateList.add(new Accountant(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new Accountant(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new Accountant(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
        candidateList.add(new Accountant(faker.name().firstName(), faker.random().nextInt(500, 3000), faker.random().nextBoolean()));
    }

    /**
     * @return employeeList with {@link Employee}
     * @throws EmployeeNotFoundException
     */
    public List<Employee> getEmployeeList() throws EmployeeNotFoundException {
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException("Employee list is empty");
        }
        return employeeList;
    }

    /**
     * @return filteredEmployeeList with {@link Employee}
     * @throws EmployeeNotFoundException
     */
    public List<Employee> getFilteredEmployeeList() throws EmployeeNotFoundException{
        if (filteredEmployeeList.isEmpty()) {
            throw new EmployeeNotFoundException("Filteredlist is empty!");
        }
        return filteredEmployeeList;
    }

    /**
     * @return candidateList with {@link Employee}
     * @throws EmployeeNotFoundException
     */
    public List<Employee> getCandidateList() throws EmployeeNotFoundException {
        if (candidateList.isEmpty()) {
            throw new EmployeeNotFoundException("Candidate list is empty!");
        }
        return candidateList;
    }

    /**
     * Goes over candidteList, checks out whether
     * {@link Employee#isHired()} and add to employeeList if true.
     * @param candidateList
     */
    public void filterCandidates(List<Employee> candidateList) {
        for (Employee candidate : candidateList) {
            if (candidate.isHired()) {
                employeeList.add(candidate);
            }
        }
    }

    /**
     *  Goes over candidteList, checks out whether
     *  {@link Employee#getSalary()} is more than entered by user salary and add to filteredEmployeeList if true.
     *
     * @param employeeList
     * @param salary
     * @return filled filteredEmployeeList
     */
    public List<Employee> getEmployeesWithSalaryMoreThan(List<Employee> employeeList, int salary) {
        for (Employee employee : employeeList) {
            if (employee.getSalary() > salary) {
                filteredEmployeeList.add(employee);
            }
        }
        return filteredEmployeeList;
    }
}
