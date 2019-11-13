package testpackage.firstTry.cinema;

import java.util.Scanner;

public interface ICinema {
        Scanner in = new Scanner(System.in);
         Object showActualFilms(String film,String name);
         Object chooseFilm(String film,String name);
}
