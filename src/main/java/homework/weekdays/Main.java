package homework.weekdays;

import java.util.Scanner;

/**
 * This class runs week days
 *
 * @author Kontsevych Mykyta
 * @version 1.0 08 November 2019
 */

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a day: ");

        String inputDay = in.nextLine().toUpperCase();

        try {
            WeekDays currentDay = WeekDays.valueOf(inputDay);
            System.out.println(currentDay.getTomorrowDay());
        } catch (Exception e) {
            System.out.println("You entered a wrong day name.");
        }
    }
}
