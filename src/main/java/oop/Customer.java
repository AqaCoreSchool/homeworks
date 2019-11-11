package oop;

import java.util.Scanner;

public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
