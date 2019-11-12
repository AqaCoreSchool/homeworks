import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int price = 100;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter age :");

        int a = scanner.nextInt();

        Adult adult = new Adult(a, price);
        Child child = new Child(a, price);

        if (a >= 14) {
            adult.getHuman();
        } else {
            child.getHuman();
        }

        SingleRoom singleRoom = new SingleRoom(100);
        singleRoom.getPriceRoom();
        DoubleRoom doubleRoom = new DoubleRoom(200);
        doubleRoom.getPriceRoom();

        Payment payment = new Payment();
        payment.cashToPay();
        payment.cashlessToPay();


    }
}