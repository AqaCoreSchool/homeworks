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
            adult.human();
        } else {
            child.human();
        }

        SingleRoom singleRoom = new SingleRoom(100);
        singleRoom.PriceRoom();
        DoubleRoom doubleRoom = new DoubleRoom(200);
        doubleRoom.PriceRoom();

        Payment payment = new Payment();
        payment.cash();
        payment.cashless();


    }
}