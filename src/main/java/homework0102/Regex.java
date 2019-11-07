package homework0102;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        System.out.println("Enter name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]+\\s{1}[A-Z]{1}[a-z]+$");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            System.out.println("Valid name");
        } else {
            System.out.println("Invalid name");
        }
    }
}
