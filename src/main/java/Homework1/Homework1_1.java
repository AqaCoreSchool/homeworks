package Homework1;

import java.util.Scanner;

public class Homework1_1 {


    public static void main(String[] args) {

        DaysOfWeek[] AllDaysOfWeek = DaysOfWeek.values();
        {
            String textMessage = ("Day is wrong, try again please");


            System.out.println("Please enter day:");
            Scanner scan = new Scanner(System.in);
            String text = scan.next().toUpperCase();
            for (DaysOfWeek day : AllDaysOfWeek)
                if (text.equalsIgnoreCase(day.toString())) {
                    System.out.println("Next day " + day.nextDay());
                    textMessage = ("");
                }
            System.out.println(textMessage);
        }
    }
}
