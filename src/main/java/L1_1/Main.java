package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            Days userDay = Days.valueOf(input.toUpperCase());
            System.out.println(userDay.nextDay());
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}
