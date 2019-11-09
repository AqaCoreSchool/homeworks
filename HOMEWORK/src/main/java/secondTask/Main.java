package secondTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first and last name: ");
        String str = in.nextLine();
        if (str.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+$")) {
            System.out.println("Thank you, the introduction was successful");
        } else {
            System.out.println("Your first or last name was entered incorrectly");
        }
    }

}
