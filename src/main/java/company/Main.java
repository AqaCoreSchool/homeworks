package company;

import company.common.Common;
import company.exception.EmployeeNotFoundException;

import java.util.Scanner;
/**
 * Implements an application that creates {@link Company}
 * with {@link Employee}, who is hired or not and filters
 * by {@link Employee#getSalary()}.
 *
 * @see Employee#isHired()
 *
 * @author  Pavlo Hrytsyshyn
 * @version 1.0
 * @since   2019-11-15
 */
public class Main {
    public static void main(String[] args) throws EmployeeNotFoundException {
        System.out.println("Enter salary:");
        Scanner userInput = new Scanner(System.in);
        int salary = userInput.nextInt();
        Company company = new Company();
        company.filterCandidates(company.getCandidateList());
        company.getEmployeesWithSalaryMoreThan(company.getEmployeeList(), salary);
        Common.printEmployees(company.getFilteredEmployeeList());
        System.out.println("Enter '1' to show candidates list");

        if (userInput.nextInt() == 1) {
            Common.printEmployees(company.getCandidateList());
        }
    }
}
