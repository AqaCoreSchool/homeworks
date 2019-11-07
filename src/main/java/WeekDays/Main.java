package WeekDays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentDay = sc.next().toUpperCase();

        WeekDays[] days = WeekDays.values();
        for (WeekDays day : days) {
            if (currentDay.equals(day.toString())) {
                System.out.println(day.nextDay());
                break;
            }
        }
    }
}