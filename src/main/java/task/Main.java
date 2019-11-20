package task;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String TEMPLATE = "Name: %s, salary: %s, balance: %s";

    public static void main(String[] args) {
        List<Person> people = DataGenerator.generatePeople();

        List<Person> peopleWithSuspiciousBankAccounts = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getBankAccount().isActive() && person.getBankAccount().getBalance() > person.getSalary()) {
                if (getIncomeSinceAccountStartDate(person) <= person.getBankAccount().getBalance()) {
                    continue;
                } else {
                    peopleWithSuspiciousBankAccounts.add(people.get(i));
                }
            }
        }
        String result = "";
        for (Person person : peopleWithSuspiciousBankAccounts) {
            result = result + fillInTemplateRow(person);
            result += "\n";
        }
        result = result.replaceAll("\\n$", "");

        System.out.println(result);

    }

    private static double getIncomeSinceAccountStartDate(Person person) {
        return person.getSalary() * getAmountOfMonthSinceDate(person.getBankAccount().getStartDate());
    }

    private static String fillInTemplateRow(Person person) {
        return String.format(TEMPLATE, person.getName(), person.getSalary(), person.getBankAccount().getBalance());
    }

    private static long getAmountOfMonthSinceDate(LocalDate date) {
        return ChronoUnit.MONTHS.between(date, LocalDate.now());
    }

}
