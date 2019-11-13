package testpackage.firstTry.cinema;

import testpackage.firstTry.film.Malificent;
import testpackage.firstTry.film.Prometheus;

public class ThreeD implements ICinema {
    private String arr[] = {"Malificent","Prometheus"};

    @Override
  public Object showActualFilms(String film,String name) {
        System.out.println("Select a movie:");
        for(int i =0;i<arr.length;i++){
            int a = i+1;
            System.out.println(a+"."+arr[i]);
        }
        chooseFilm(film,name);
        return null;
    }

    @Override
   public Object chooseFilm(String film,String name) {
        System.out.println("Enter the movie number:");
        int b = in.nextInt();
        if(b == 1){
            String nameFilm = "Malificent";
                return new Malificent().chooseDate(film,nameFilm,name);
            }else {
                if(b==2){
                    String nameFilm = "Prometheus";
                    return  new Prometheus().chooseDate(film,nameFilm,name);
                }
            }
        return null;
    }
}
