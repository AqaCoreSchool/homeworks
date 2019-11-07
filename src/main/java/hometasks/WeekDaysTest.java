package hometasks;

import java.util.Scanner;

public class WeekDaysTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your day here");
        String days = scan.next().toUpperCase();

        for(WeekDays day: WeekDays.values()) {
            if(days.equals(day.toString())) {
                System.out.println(day.getNextDay());
            }
        }
    }
}
