package company;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Company {


    public static void main(String[] args) {
        Faker faker = new Faker();


        List<Employee> workers = new ArrayList<Employee>();


        workers.add(new Director((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(5000, 6000), faker.random().nextBoolean()));
        workers.add(new Accountant((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(1000, 2000), faker.random().nextBoolean()));
        workers.add(new Accountant((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(1000, 2000), faker.random().nextBoolean()));
        workers.add(new Dev((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(3000, 5000), faker.random().nextBoolean()));
        workers.add(new Dev((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(3000, 5000), faker.random().nextBoolean()));
        workers.add(new Dev((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(3000, 5000), faker.random().nextBoolean()));
        workers.add(new QualityAssurance((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(2000, 3000), faker.random().nextBoolean()));
        workers.add(new QualityAssurance((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(2000, 3000), faker.random().nextBoolean()));
        workers.add(new QualityAssurance((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(2000, 3000), faker.random().nextBoolean()));
        workers.add(new Manager((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(500, 1500), faker.random().nextBoolean()));
        workers.add(new Manager((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(500, 1500), faker.random().nextBoolean()));
        workers.add(new Manager((faker.name().firstName() + " " + faker.name().lastName()), faker.random().nextInt(500, 1500), faker.random().nextBoolean()));

        System.out.println("Full l");
        for (Employee i : workers)
            System.out.println(i.getEmployeeName() + " " + i.getEmployeeSalary() + " " + i.isEmployeeHired());
        getEmployeeWithSalaryMoreThan(3000, workers);

    }

    private static void getEmployeeWithSalaryMoreThan(int minSalary, List<Employee> workers) {
        List<Employee> listWithBiggerSalary = new ArrayList<>();
        for (Employee person : workers) {
            if (person.getEmployeeSalary() > minSalary) {
                listWithBiggerSalary.add(person);
            }
        }
        System.out.println("new list of employee with salary more than " +minSalary+":--------------------------------");
        for (Employee i : listWithBiggerSalary)
            System.out.println(i.getEmployeeName() + " " + i.getEmployeeSalary() + " " + i.isEmployeeHired());


    }

}
