package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your full name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        checkName(name);
    }

    public static void checkName(String name) {
        Pattern pattern = Pattern.compile("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            System.out.println("Good!");
        } else {
            System.out.println("Check your input!");
        }
    }
}
