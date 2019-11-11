package oop;

import java.util.Scanner;

public class Customer {

    Scanner scan = new Scanner(System.in);


    public Object selectHall(){
        System.out.println("Please select a hall: IMAX or REAL2D");
        String movie = scan.nextLine().toUpperCase();


        if(movie.matches("IMAX")){
            return new Imax().showListOfFilms();
        }else if(movie.matches("REAL2D")){
            return new Real2D().showListOfFilms();
        }
        return selectHall();
    }
}
