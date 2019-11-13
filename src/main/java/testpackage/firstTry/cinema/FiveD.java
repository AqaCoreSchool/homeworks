package testpackage.firstTry.cinema;

import testpackage.firstTry.film.Malificent;
import testpackage.firstTry.film.Terminator;


public class FiveD implements ICinema{
    private String arr[] = {"Terminator","Malificent"};

    public Object showActualFilms(String film,String name){
       System.out.println("Select a movie:");
       for(int i =0;i<arr.length;i++){
           int a = i+1;
           System.out.println(a+"."+arr[i]);
       }
       chooseFilm(film,name);
       return null;
   }
    public Object  chooseFilm(String film,String name){
        System.out.println("Enter the movie number:");
        int b = in.nextInt();
         if(b == 1){
           String nameFilm = "Terminator";
           return new Terminator().chooseDate(film,nameFilm,name);
         }else {
             if(b == 2){
               String nameFilm = "Malificent";
               return new Malificent().chooseDate(film,nameFilm,name);
             }
         }
       return null;
   }
}
