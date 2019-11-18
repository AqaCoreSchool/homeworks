package company;

public class CompanyTest {

    public static void main(String[] args) {

        // initialization of company
        Company company = new Company("CoreValue");

        System.out.println();

        // initialization of employees
        System.out.println("Adding of new employees:");
        company.addEmployee(new Director("John Frist", 25000));
        company.addEmployee(new QA("Fred First", 3000));
        company.addEmployee(new QA("Fred Second", 3000));
        company.addEmployee(new Developer("Ingemar First", 5000));
        company.addEmployee(new Developer("Ingemar Second", 4000));
        company.addEmployee(new Developer("Ingemar Third", 3000));
        company.addEmployee(new Developer("Ingemar Fourth", 5000));
        company.addEmployee(new Accountant("Jack First", 1500));
        company.addEmployee(new Accountant("Jack Second", 1700));
        company.addEmployee(new Manager("Abraham First", 7000));
        company.addEmployee(new Manager("Abraham Second", 8000));

        System.out.println();

        // print employees list
        System.out.printf("List of all employees of %s company\n",
                company.getName());
        company.printEmployees();

        System.out.println();

        int salaryToCompare = 3000;

        // print filtered employees list
        System.out.printf("List of all employees of %s company with salary > %d\n",
                company.getName(),
                salaryToCompare);
        company.printFilteredEmployees(company.getEmployeesListBySalaryMoreThan(salaryToCompare));
    }

}
