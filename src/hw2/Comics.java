package hw2;

public class Comics extends Library implements Artistic {
    private String current_author;
    private int current_year;

    Comics(String a, int y){
        super(a,y);
        current_author = a;
        current_year = y;
    }

    int c_year(){
        return current_year;
    }

    String c_author(){
        return current_author;
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
        System.out.println(String.format("Comics %s from |%d|", getName(), getYear()));
    }

    @Override
    public void pay(double price) {
        System.out.println(String.format("%s Book have price |%f|", getName(), price));
    }
}
