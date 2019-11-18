package cinema;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Method item = new Method();
        Scanner userInput = new Scanner(System.in);
        Scanner innerInput;
        String innerString;

        System.out.println("Name : Genre : Country : Year");
        System.out.println("***********************************");
        item.getAllFilms();
        System.out.println("***********************************");

        System.out.println("Choose one of number:");
        System.out.println("1. Retrieve list of movie session.");
        System.out.println("2. Sort all books.");
        System.out.println("3. Check if at least one book in your list corresponds to release year.");
        System.out.println("4. Are all books correspond genre.");
        System.out.println("5. Filtered by alphabetic");
        System.out.println("6. Are none of books corresponds to author.");
        /*System.out.println("7. Collect the oldest book names per each genre, sort them alphabetically and\n" +
                "print them to console using comma as a delimiter");*/
        System.out.println("8. Map task.");
        System.out.println("INFO: enter 'exit' to finish");

        while (userInput.hasNext()) {
            if (userInput.equals("1")) {
                System.out.println("Enter genre:");
                innerInput = new Scanner(System.in);
                innerString = innerInput.next();
                item.getFilmsByGenre(innerString);
            } else if (userInput.equals("2")) {
                System.out.println("Enter year:");
                innerInput = new Scanner(System.in);
                innerString = innerInput.next();
                double doubleItem = Double.parseDouble(innerString);
                item.checkOneByYear(doubleItem);
            }else if(userInput.equals("3")){
                System.out.println("Enter the time:");
                innerInput =new Scanner(System.in);
                innerString = innerInput.next();
                float floatItem = Float.parseFloat(innerString);
                item.checkOneByTime(floatItem);
            }else if(userInput.equals("4")){
                System.out.println("Sort by alphabetic");
                item.getAlphabeticFilm();
            }

        }
    }
}
