package com.company;

import java.util.Scanner;

public class Main {

    public final static int lotCount = 100;
    public static int freeLots = 100;

    public static void main(String[] args) {
        Employees s1 = new SecurityStaff();
        s1.setStaff("Ivan", 250);
        System.out.println(s1.toString());
        Employees admin1 = new Admin("Petro", 80);
        System.out.println(admin1.toString());

        Vehicle v1 = new Truck();
        v1.setVehicle("DC 6789 HJ", "Ivan Ivanov");
        System.out.println(v1.toString());

        // next rows just for testing checkIN and getDill methods
        v1.checkOut();
        v1.checkIn();

        System.out.println("Hello, please enter something");
        Scanner scanner = new Scanner(System.in);
        String s2 = scanner.nextLine();
        v1.checkOut();

    }
}
