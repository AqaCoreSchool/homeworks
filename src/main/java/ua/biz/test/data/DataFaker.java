package ua.biz.test.data;

import com.github.javafaker.Faker;

public class DataFaker {
    // add employee
    private String firstName;
    private String lastName;
    private int code;

    // save exp
    private String company;
    private String title;
    private String fromDate;
    private String toDate;

    public DataFaker() {
        Faker faker = new Faker();

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        code = faker.random().nextInt(1000, 2000);

        company = faker.company().name();
        title = faker.company().profession();
        fromDate = String.format("%d-%d-%d",
                faker.random().nextInt(1990, 2005),
                faker.random().nextInt(10, 12),
                faker.random().nextInt(10, 27));
        toDate = String.format("%d-%d-%d",
                faker.random().nextInt(2006, 2019),
                faker.random().nextInt(10, 12),
                faker.random().nextInt(10, 27));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCode() {
        return code;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }
}
