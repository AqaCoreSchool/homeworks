package testpackage.firstTry.people;

import testpackage.firstTry.cinema.FiveD;
import testpackage.firstTry.cinema.ThreeD;
import testpackage.firstTry.cinema.TwoD;

import java.util.Scanner;

public class Client {

    private String firstName;

    private int age;

    Scanner in = new Scanner(System.in);

    String film;

    public Client(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object cinemaChoice(){
        System.out.println("Select a movie theater: 2D, 3D, 5D.");
        String movie = in.nextLine();
        String name = getFirstName();
        if(movie.matches("2D")){
            film ="2D";
            return new TwoD().showActualFilms(film,name);
        }else{
            if(movie.matches("3D")){
                film ="3D";
                return new ThreeD().showActualFilms(film,name);
            }else {
                if (movie.matches("5D")){
                    film ="5D";
                    return new FiveD().showActualFilms(film,name);
                }else {
                    return null;
                }
            }
        }
    }
}
