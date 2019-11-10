package com.rybka.homework1;

import java.util.Scanner;

enum DaysOfWeek {
    MONDAY {
        @Override
        Enum nextDay() {
            return TUESDAY;
        }
    },
    TUESDAY {
        @Override
        Enum nextDay() {
            return WEDNESDAY;
        }
    },
    WEDNESDAY {
        @Override
        Enum nextDay() {
            return THURSDAY;
        }
    },
    THURSDAY {
        @Override
        Enum nextDay() {
            return FRIDAY;
        }
    },
    FRIDAY {
        @Override
        Enum nextDay() {
            return SATURDAY;
        }
    },
    SATURDAY {
        @Override
        Enum nextDay() {
            return SUNDAY;
        }
    },
    SUNDAY {
        @Override
        Enum nextDay() {
            return MONDAY;
        }
    };

    abstract Enum nextDay();
}

public class WeekDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter any day please: ");
        String day = scanner.next();

        switch (day.toUpperCase()) {
            case "MONDAY":
                System.out.println("The next day is " + DaysOfWeek.MONDAY.nextDay());
                break;
            case "TUESDAY":
                System.out.println("The next day is " + DaysOfWeek.TUESDAY.nextDay());
                break;
            case "WEDNESDAY":
                System.out.println("The next day is " + DaysOfWeek.WEDNESDAY.nextDay());
                break;
            case "THURSDAY":
                System.out.println("The next day is " + DaysOfWeek.THURSDAY.nextDay());
                break;
            case "FRIDAY":
                System.out.println("The next day is " + DaysOfWeek.FRIDAY.nextDay());
                break;
            case "SATURDAY":
                System.out.println("The next day is " + DaysOfWeek.SATURDAY.nextDay());
                break;
            case "SUNDAY":
                System.out.println("The next day is " + DaysOfWeek.SUNDAY.nextDay());
                break;
            default:
                System.out.println("There is no day like this!");
                break;
        }
    }
}
