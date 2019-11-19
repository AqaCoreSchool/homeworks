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

        System.out.println("Choose one of number:");
        System.out.println("1. Retrieve list of movie session.");
        System.out.println("2. Retrieve list of movies filtered by particular genre");
        System.out.println("3. Sort all movies alphabetically");
        System.out.println("4. Corresponds to some search criteria - year.");
        System.out.println("5. Corresponds to some search criteria - duration.");
        System.out.println("6. Corresponds to some search criteria - movie name.");
        System.out.println("7. Map task.");
        System.out.println("INFO: enter 'exit' to finish");

        while (userInput.hasNext()) {
            switch(userInput.next()){
                case "1":
                    System.out.println("Name : Genre : Country : Year");
                    item.getAllFilms();
                    break;
                case "2":
                    System.out.println("Enter genre:");
                    innerInput = new Scanner(System.in);
                    innerString = innerInput.next();
                    item.getFilmsByGenre(innerString);
                    break;
                case "3":
                    System.out.println("Sort by alphabetic");
                    item.getAlphabeticFilm();
                    break;
                case "4":
                    System.out.println("Enter year:");
                    innerInput = new Scanner(System.in);
                    innerString = innerInput.next();
                    double doubleItem = Double.parseDouble(innerString);
                    item.checkOneByYear(doubleItem);
                    break;
                case "5":
                    System.out.println("Enter the time:");
                    innerInput =new Scanner(System.in);
                    innerString = innerInput.next();
                    float floatItem = Float.parseFloat(innerString);
                    item.checkOneByTime(floatItem);
                    break;
                case "6":
                    System.out.println("Map");
                    item.putValuesInMap(item.getFilmList());
                    System.out.println(item.getMap().keySet() + ":" + item.getMap().values());
                    break;
            }


        }
    }
}
