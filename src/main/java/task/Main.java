package task;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final String TEMPLATE = "Name: %s, salary: %s, balance: %s";
    private static List<Person> people = generatePeople();
    private static List<Person> peopleWithSuspiciousBankAccounts = new ArrayList<>();
    private static List<Person> peopleWithSuspiciousBankAccountsWithLambda = new ArrayList<>();

    public static void main(String[] args) {

        addPeopleWithSuspiciousBankAccounts();
        addPeopleWithSuspiciousBankAccountsWithLambda();

        String result = getPeopleWithSuspiciousBankAccounts();
        String result1 = getPeopleWithSuspiciousBankAccountsWithLambda();

        System.out.println(result);
        System.out.println("====================================");
        System.out.println(result1);
        System.out.println("Usual and lambda are equal: " + result.equals(result1));

    }

    private static List<Person> generatePeople() {
        Faker faker = new Faker();
        return IntStream.rangeClosed(1, 1000).mapToObj(i -> {
            int age = faker.number().numberBetween(18, 60);
            double salary = faker.number().randomDouble(2, 100, 10000);
            Person person = new Person(faker.name().fullName(), age, salary);

            boolean isActive = faker.bool().bool();
            double balance = isActive ? faker.number().randomDouble(2, 100, 50000) : 0;
            int weeksAgo = faker.number().numberBetween(4, 26);
            person.setBankAccount(new BankAccount(faker.company().name(), balance, isActive, LocalDate.now().minusWeeks(weeksAgo)));
            return person;
        }).collect(Collectors.toList());
    }

    private static void addPeopleWithSuspiciousBankAccounts() {
        // usual
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getBankAccount().isActive() && person.getBankAccount().getBalance() > person.getSalary()
                    && getIncomeSinceAccountStartDate(person) > person.getBankAccount().getBalance()) {
                peopleWithSuspiciousBankAccounts.add(people.get(i));
            }
        }
    }

    private static void addPeopleWithSuspiciousBankAccountsWithLambda() {
        // java 8
        people.stream()
                .filter(person -> person.getBankAccount().isActive()
                        && person.getBankAccount().getBalance() > person.getSalary())
                .filter(person -> getIncomeSinceAccountStartDate(person) > person.getBankAccount().getBalance())
                .forEach(peopleWithSuspiciousBankAccountsWithLambda::add);
    }

    private static String getPeopleWithSuspiciousBankAccounts() {
        // usual
        String result1 = "";
        for (Person person : peopleWithSuspiciousBankAccounts) {
            result1 = result1 + fillInTemplateRow(person);
            result1 += "\n";
        }
        return result1.replaceAll("\\n$", "");
    }

    private static String getPeopleWithSuspiciousBankAccountsWithLambda() {
        // java 8
        String result = "";
        result = peopleWithSuspiciousBankAccountsWithLambda.stream().map(Main::fillInTemplateRow).peek(result::concat)
                .collect(Collectors.joining("\n"));
        return result;
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
