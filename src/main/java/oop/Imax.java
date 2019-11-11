package oop;

import oop.Cinema;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Imax extends Cinema {
    private  int capasity;
    private  String kindOfScreen;
    private List<String> films = new ArrayList<>(Arrays.asList("STAR WARS", "SPIDER MAN"));


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
        this.films =  films;
    }

    @Override
    public String showListOfFilms() {
        System.out.println("Movies in the IMAX this week:");
        for (String elem: films){
            System.out.println(elem);
        }
        choosePreferFilm();
        return null;
    }

    @Override
    public Object choosePreferFilm() {
        System.out.println("Enter a movie name:");
        String movieName = scan.nextLine().toUpperCase();

        if (movieName.matches("STAR WARS")){
            System.out.println("Movie rating - 16+");
            return new StarWars("STAR WARS", 2012,
                                133, "Fantasy").getDate();
        }else if(movieName.matches("SPIDER MAN")){
            System.out.println("Movie rating - 12+");
            return new SpiderMan("SPIDER MAN", 2002,
                                126, "Action").getDate();
        }else {
            System.out.println("Incorrect input");
        }
        return null;
    }


}

