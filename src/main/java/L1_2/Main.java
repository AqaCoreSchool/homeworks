package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    static String pattern = "(^[A-Z][a-z]+)(\\s)([A-Z])([a-z]+$)";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter your name and surname ");
        checkInput(sc);
    }

    public static void checkInput(Scanner sc) {
        String input = sc.nextLine();
        sc.close();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        if (m.matches()) {
            System.out.println("Hello " + input);
        } else
            System.out.println("Wrong format");
    }
}
