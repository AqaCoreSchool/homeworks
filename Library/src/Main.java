import java.text.Collator;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList catalog = new LinkedList(  );
        Main main = new Main();
        Book []books = new Book[4];
        books[0] = new Book( "Harry Potter", "Rowling","fantasy",
                                     600 );
        books[1] = new Book( "IT", "Stephen King","horrors",
                            1340 );
        books[2] = new Book( "Green mile", "Stephen King","drama",

                                   1000 );
        books[3] = new Book( "A", "A","drama",

                             1000 );

        main.addBook( catalog,books );
        main.printAvailableBooks( catalog );
        Collections.sort(catalog, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Collator.getInstance().compare(o1, o2);
            }
        });


    }


    public List addBook(List catalog, Book[] books){
        for (Book book: books) {
            catalog.add(book);
        }
       return catalog;
    }
    public void printAvailableBooks(List catalog){
        Book book;
        for (int i = 0; i <catalog.size() ; i++) {
            book = (Book) catalog.get( i );
            System.out.println(book.getName());
        }
    }
}