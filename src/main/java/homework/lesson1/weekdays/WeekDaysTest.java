package homework.lesson1.weekdays;

import java.util.Scanner;

public class WeekDaysTest{

    public static void main(String[] args) {

        WeekDays weekDays[] = WeekDays.values();

        Scanner in = new Scanner(System.in);

        String str;
        boolean flag = false;
        WeekDays weekDay;
        int i = 0;

        while (!flag) {
            System.out.print("Enter a week day: ");
            str = in.nextLine();

            while (i < weekDays.length) {
                weekDay = weekDays[i];

                if (str.toUpperCase().equals(weekDay.toString())) {
                    System.out.printf("The next day is: %s\n", weekDay.nextDay());
                    flag = true;
                    break;
                }
                i++;
            }
            if (!flag) {
                i = 0;
                System.out.println("Incorrect input. Please, re-enter.");
            }
        }
    }
}
