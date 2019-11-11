package homework_1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullName {
    public static void main(String[] args) {
        System.out.print("Please, enter your full name: ");
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$");
        Matcher matcher = pattern.matcher(fullName);
        if (matcher.matches()) {
            System.out.println("Full name is incorrect");
        }
        else {
            System.out.println("Please, enter correct your full name");
        }
    }
}
