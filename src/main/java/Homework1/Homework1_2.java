package Homework1;

import java.util.Scanner;

public class Homework1_2 {
    public static void main(String[] args){

        System.out.println("Please enter your first and last name:");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        if (text.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+$")) {
            System.out.println("Successful");
        } else {
            System.out.println("Both names should start from uppercase");
        }
    }

}

