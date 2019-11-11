package Homework1;

import java.util.Scanner;

public class Homework1_1 {
    public static void main(String[] args) {
        System.out.println("Please enter day:");
        Scanner scan = new Scanner(System.in);
        String text = scan.next().toUpperCase();

        switch (text) {
            case "MONDAY":
                System.out.println("Next day: " + DaysOfWeek.TUESDAY);
                break;
            case "TUESDAY":
                System.out.println("Next day: " + DaysOfWeek.WEDNESDAY);
                break;
            case "WEDNESDAY":
                System.out.println("Next day: " + DaysOfWeek.THURSDAY);
                break;
            case "THURSDAY":
                System.out.println("Next day: " + DaysOfWeek.FRIDAY);
                break;
            case "FRIDAY":
                System.out.println("Next day: " + DaysOfWeek.SATURDAY);
                break;
            case "SATURDAY":
                System.out.println("Next day: " + DaysOfWeek.SUNDAY);
                break;
            case "SUNDAY":
                System.out.println("Next day: " + DaysOfWeek.MONDAY);
                break;
            default:
                System.out.println("The day not exist, try again please");
                break;
        }
    }
}
