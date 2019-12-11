package desingpatterns.singleton;

import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        Thread thread = new Thread(() -> System.out.println("thread 1: "  + singleton + " " + LocalDateTime.now()));
        Thread thread2 = new Thread(() -> System.out.println("thread 2: " + singleton2 + " " + LocalDateTime.now()));

        thread.run();
        thread2.run();
    }
}
