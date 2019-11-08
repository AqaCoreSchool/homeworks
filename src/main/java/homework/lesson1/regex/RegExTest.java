package homework.lesson1.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class RegExTest {

    public static void main(String[] args) {
        System.out.print("Enter name and surname: ");
        Scanner in = new Scanner(System.in);
        String testString = in.nextLine();

        Pattern p = Pattern.compile("^[A-Z][a-z]{2}+\\s[A-Z][a-z]{2}+$");
        Matcher m = p.matcher(testString);
        boolean b = m.matches();

        if (b) {
            System.out.println("Entered name is correct");
        }
        else {
            System.out.println("Entered name is not correct.");
        }
    }
}
