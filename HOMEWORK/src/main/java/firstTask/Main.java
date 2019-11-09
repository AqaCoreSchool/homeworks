package firstTask;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Enter the day of the week: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        DaysOfTheWeek day = DaysOfTheWeek.valueOf(str.toUpperCase());
        switch (day){
            case MONDAY:
            case TUESDAY:
            case FRIDAY:
            case SUNDAY:
            case SATURDAY:
            case THURSDAY:
            case WEDNESDAY:
                day.getNextDay();
                String d = day.getNextDay().toString();
                System.out.println(d);
                break;
            default:
                System.out.println("You did not correctly indicate the day of the week");
        }
    }
}
