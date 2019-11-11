package oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Real2D extends Cinema {
    private  int capasity;
    private  String kindOfScreen;
    private List<String> films = new ArrayList<>(Arrays.asList("TITANIC", "MADAGASKAR"));

    public int getCapasity() {
        return capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

    public String getKindOfScreen() {
        return kindOfScreen;
    }

    public void setKindOfScreen(String kindOfScreen) {
        this.kindOfScreen = kindOfScreen;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    @Override
    public String showListOfFilms() {
        System.out.println("Movies in the REAL2D this week");
        for (String elem: films){
            System.out.println(elem);
        }
        choosePreferFilm();
        return  null;
    }

    @Override
    public Object choosePreferFilm() {
        System.out.println("Enter a movie name");
        String movieName = scan.nextLine().toUpperCase();

        if (movieName.matches("TITANIC")){
            System.out.println("Movie rating - 16+");
            return new Titanic("TITANIC", 1997,
                                195, "Drama").getDate();
        }else if(movieName.matches("MADAGASKAR")){
            System.out.println("Movie rating - 3+");
            return new Madagaskar("Madagaskar", 2005,
                                108, "Animation").getDate();
        }else {
            System.out.println("Incorrect input");
        }
        return null;
    }


}

