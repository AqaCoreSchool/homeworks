package testpackage.firstTry;

import testpackage.firstTry.people.Client;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       System.out.println("Enter name:");
       String name = in.nextLine();
       System.out.println("Enter age:");
       int age = in.nextInt();
       Client client = new Client(name,age);
       client.cinemaChoice();
    }
}
