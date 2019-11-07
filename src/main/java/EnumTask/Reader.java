package EnumTask;

import java.util.Scanner;

public class Reader {
    public void consoleRead() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your day of week : ");
            String lul = sc.nextLine();
            WeekDays week = WeekDays.valueOf(lul);
            System.out.println(week.nextDay());
        }catch (IllegalArgumentException ex){
            System.out.println("Word should be in upper-case only");
        }
    }
}
