import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the day of the week : ");

        String phrase = scan.nextLine();

        DayOfWeek dayOfWeek = DayOfWeek.valueOf(phrase.toUpperCase());

        switch (dayOfWeek){
            case SUNDAY:
                System.out.println("MONDAY");
                break;
            case MONDAY:
                System.out.println("TUESDAY");
                break;
            case TUESDAY:
                System.out.println("WEDNESDAY");
                break;
            case WEDNESDAY:
                System.out.println("THURSDAY");
                break;
            case THURSDAY:
                System.out.println("FRIDAY");
                break;
            case FRIDAY:
                System.out.println("SATURDAY");
                break;
            case SATURDAY:
                System.out.println("SUNDAY");
                break;
        }

        scan.close();
    }

}
