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


        /*
         * Running with concrete method by Ordinal();
         * */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your day here");
        String dDays = scanner.next().toUpperCase();


        switch (dDays){
            case "MONDAY": System.out.println(WeekDays.MONDAY.getNextDayByOrdinal());
                break;
            case "TUESDAY": System.out.println(WeekDays.TUESDAY.getNextDayByOrdinal());
                break;
            case "WEDNESDAY": System.out.println(WeekDays.WEDNESDAY.getNextDayByOrdinal());
                break;
            case "THURSDAY": System.out.println(WeekDays.THURSDAY.getNextDayByOrdinal());
                break;
            case "FRIDAY": System.out.println(WeekDays.FRIDAY.getNextDayByOrdinal());
                break;
            case "SATURDAY": System.out.println(WeekDays.SATURDAY.getNextDayByOrdinal());
                break;
            case "SUNDAY": System.out.println(WeekDays.SUNDAY.getNextDayByOrdinal());
                break;
            default:
                System.out.println("Incorrect input");

        }
    }
}
