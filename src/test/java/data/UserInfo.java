package data;

import com.github.javafaker.Faker;

public class UserInfo {

    Faker faker = new Faker();
    public static final String URL = "http://test.biz.ua";
    public static final String LOGIN = "TestUser02";
    public static final String PASSWORD = "Vfylhfujhf!1";
    public String firstName = faker.name().firstName();
    public static final String LASTNAME = "Shtyiuk";
    public static final String ID = "02";
    public static final String BIRTH_DATE = "1987-11-23";
    public static final String EMAIL = "andriy.shtyiuk@gmail.com";
    public static final String PHONE_NUMBER = "0686478967";



}
