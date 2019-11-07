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

    /*
     This method returns next day after user input day.
     */
    public static void getNextDay() throws IOException {

        WeekDay[] allWeekDays = WeekDay.values();

        System.out.println("Please. Type here name of day");

        boolean flag = true;

        while (flag) {
            String userDay = getUserDay();
            String output = "Next day is: ";
            for (WeekDay day : allWeekDays)
                if (userDay.equalsIgnoreCase(day.toString())) {
                    flag = false;
                    System.out.println(output.concat(day.getNextDay().toString()));
                }
            if (flag) System.out.println("Type name of day correctly.");

        }
    }


    /*
    This method compares user input with RegEx
     */
    public static void getCorrectlyName() throws IOException {
        boolean flag = true;
        System.out.println("Please. Type here your first name and last name!");
        while (flag) {
            String userDay = getUserDay();
            if (userDay.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+$")) {
                flag = false;
                System.out.println("Thank you");
            } else {
                System.out.println("Type your first and last name correctly. For example 'Ivan Ivanchuk'");
            }
        }

    }

    /*
     This method reads user input and return us readed string
     */
    public static String getUserDay() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

}
