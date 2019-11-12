package rybka.oop;

public class Customer {
    private String name;
    private String filmTitle;
    private String filmStart;
    private int customerPlace;

    Customer(String name, String filmTitle, String filmStart, int customerPlace) {
        this.name = name;
        this.filmTitle = filmTitle;
        this.filmStart = filmStart;
        this.customerPlace = customerPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmStart() {
        return filmStart;
    }

    public void setFilmStart(String filmStart) {
        this.filmStart = filmStart;
    }

    public int getCustomerPlace() {
        return customerPlace;
    }

    public void setCustomerPlace(int customerPlace) {
        this.customerPlace = customerPlace;
    }
}
