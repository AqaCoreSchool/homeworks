package testpackage.firstTry.film;

import java.util.Scanner;

public abstract class Films {
    Scanner in = new Scanner(System.in);
     abstract void chooseTime(String film,String nameFilm,String date,String name);
     abstract Object chooseDate(String film,String nameFilm,String name);
     Object verifyDate(String date){
         if (date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")){

         }else {
             return null;
         }
         return null;
     }
     void concludingAnswer(String film, String nameFilm, String date, String name, String time){
         StringBuilder s = new StringBuilder();
         s.append("Thanks for purchasing ");
         s.append(name);
         s.append(". You have chosen a movie ");
         s.append(nameFilm);
         s.append(" ( ");
         s.append(film );
         s.append(" ). ");
         s.append(date);
         s.append(" at " );
         s.append(time);
         System.out.println(s.toString());

     }
}
