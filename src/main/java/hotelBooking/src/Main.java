import customers.Adult;
import customers.Child;
import customers.Pensioner;
import hotelRooms.RoomsSort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Adult adult;
        Child child;
        Pensioner pensioner;

        try (Scanner scanner = new Scanner(System.in);){
            System.out.println("Enter age :");
            int value = scanner.nextInt();
            adult = new Adult(value, 100);
            child = new Child(value, 50);
            pensioner = new Pensioner(value, 70);

            if ((value >= 14)) {
            adult.doHuman();
            }else if(value <= 60) {
            child.doHuman();
            }else {
            pensioner.doHuman();
            }

        }catch (NumberFormatException nfe){
            System.out.println("Enter age");
        }

        RoomsSort category = new RoomsSort();
        category.getByCategory();
        category.getByCost();


        Payment payment = new Payment();
        payment.cashToPay();
        payment.cashlessToPay();


    }
}