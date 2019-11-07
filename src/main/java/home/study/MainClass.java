package home.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class MainClass {

    public static void main(String[] args) throws IOException {
        getCorrectlyName();
        System.out.println("-------------------------------------------------");
        getNextDay();
    }

    public static void getNextDay() throws IOException {
        System.out.println("Please. Type here name of day");

        WeekDay[] allWeekDays = WeekDay.values();
        String userDay = getUserDay();
        String output = "Next day is: ";
        for (WeekDay day : allWeekDays) {
            if (userDay.equalsIgnoreCase(day.toString()))
                System.out.println(output.concat(day.getNextDay().toString()));

        }
    }

    public static void getCorrectlyName() throws IOException {
        boolean flag = true;
        System.out.println("Please. Type here your first name and last name!");
        while (flag) {
            String userDay = getUserDay();
            if (userDay.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+$")) {
                flag = false;
                System.out.println("Thank you");
            } else {
                System.out.println("Please. Type your first name and last name correctly. For example 'Ivan Ivanchuk'");
            }
        }

    }


    public static String getUserDay() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

}
