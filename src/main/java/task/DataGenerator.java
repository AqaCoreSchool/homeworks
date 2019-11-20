package task;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataGenerator {

    private DataGenerator() {

    }

    public static List<Person> generatePeople() {
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

}
