package hw3;

public class Comics extends Library implements Artistic {

    Comics(String author, String name, int year, boolean avail){
        super(author, name, year, avail);
        available = avail;
    }

    @Override
    public void typing(boolean type) {
        if (!type) {
            System.out.println("Our comics must be artistic! You need to change type");
        } else {
            System.out.println("Our comics is artistic!");
        }
    }

    @Override
    public void inform() {
        System.out.println(String.format("Comics %s from |%d|", getAuthor(), getYear()));
    }

    @Override
    public void pay(double price) {
        System.out.println(String.format("%s Book have price |%f|", getAuthor(), price));
    }
}
