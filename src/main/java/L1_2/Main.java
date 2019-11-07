package com.company;
import java.util.Scanner;
import java.util.regex.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = "[A-Z]+[a-z]*\\s[A-Z]+[a-z]*";
        String input = sc.nextLine();
        sc.close();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        if (m.matches()){
            System.out.println(input);
        }
        else
            System.out.println("wrong format");
    }
}
