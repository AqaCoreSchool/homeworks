package RegTask;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    public void consoleRead() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your full name : ");
        String lul = sc.nextLine();
        Pattern pattern = Pattern.compile("^([A-Z][a-z]+((\\s)))+[A-Z][a-z]+$");
        Matcher matcher = pattern.matcher(lul);
        System.out.println("Your entered name is : " + matcher.matches());
    }
}
