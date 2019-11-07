package hometasks;

import java.util.Scanner;

public class RegExGetName {

    public static void main(String[] args) {
        System.out.println("Give your name, please");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        boolean name = input.matches("^[A-Z]{1}[a-z]+\\s[A-Z]{1}[a-z]+$");
        if(name == true){
            System.out.println("It's a correct name :-)");
        }
        else{
            System.out.println("It's not a correct name! :-(");
        }

    }
}
