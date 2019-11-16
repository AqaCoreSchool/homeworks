package company;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.getList(company.getDefaultList());
        System.out.println("\n");
        company.getList(company.getEmployeeWithSalary(3000));
        System.out.println("\n");
        company.getListName(company.employeeList);
        System.out.println("\n");
        company.getList(company.getEmployeeIsHired());
    }
}
