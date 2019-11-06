package com.rybka.homework1;

import java.util.Scanner;

enum DaysOfWeek{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

public class WeekDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter any day please: ");
        String day = scanner.next();

        switch(day.toUpperCase()){
            case "MONDAY": System.out.println("The next day is "+DaysOfWeek.TUESDAY); break;
            case "TUESDAY":  System.out.println("The next day is "+DaysOfWeek.WEDNESDAY); break;
            case "WEDNESDAY":  System.out.println("The next day is "+DaysOfWeek.THURSDAY); break;
            case "THURSDAY":  System.out.println("The next day is "+DaysOfWeek.FRIDAY); break;
            case "FRIDAY": System.out.println("The next day is "+DaysOfWeek.SATURDAY); break;
            case "SATURDAY":  System.out.println("The next day is "+DaysOfWeek.SUNDAY); break;
            case "SUNDAY":  System.out.println("The next day is "+DaysOfWeek.MONDAY); break;
            default: System.out.println("There is no day like this!"); break;
        }
    }
}
