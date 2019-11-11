package hw2;


abstract class Library {
    private String author;
    private int year;
    protected abstract void inform();
    public abstract void pay(double price);

    Library(String a, int y){
        author = a;
        year = y;
    }

    String getName() {
        return author;
    }
    int getYear() {
        return year;
    }
}
