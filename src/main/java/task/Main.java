package task;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String TEMPLATE = "Name: %s, salary: %s, balance: %s";

    public static void main(String[] args) {
        List<Person> people = DataGenerator.generatePeople();
        List<Person> peopleWithSuspiciousBankAccounts = new ArrayList<>();

        people.stream()
                .filter(person -> person.getBankAccount().isActive()
                        && person.getBankAccount().getBalance() > person.getSalary())
                .filter(person -> getIncomeSinceAccountStartDate(person) > person.getBankAccount().getBalance())
                .forEach(peopleWithSuspiciousBankAccounts::add);

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
        result = peopleWithSuspiciousBankAccounts.stream().map(Main::fillInTemplateRow).peek(result::concat)
                .collect(Collectors.joining("\n"));
        System.out.println(result);

        String result1 = "";
        for (Person person : peopleWithSuspiciousBankAccounts) {
            result1 = result1 + fillInTemplateRow(person);
            result1 += "\n";
        }
        result1 = result1.replaceAll("\\n$", "");
        System.out.println("====================================");
        System.out.println(result1);
        System.out.println("Is equal: " + result1.equals(result));

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
