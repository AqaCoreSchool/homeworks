package homework0101;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter day:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next().toUpperCase();
        for(int i = 0; i<WeekDays.days.length; i++){
            if(WeekDays.days[i].name().equals(name)){
                System.out.println(WeekDays.days[i].nextDay(WeekDays.days[i].ordinal()).name());
                System.exit(0);
            }
        }
        System.out.println("day not found");
    }
}
