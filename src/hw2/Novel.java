package hw2;


public class Novel extends Library implements Artistic {
     int rozdil;
     private String current_author;
     private int current_year;

    Novel(String a, int y, int r){
        super(a,y);
        rozdil = r;
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
            System.out.println("Our novel must be artistic maybe?");
        } else {
            System.out.println("Our novel is artistic!");
        }
    }

    @Override
    public void inform() {
        System.out.println(String.format("Novel %s from |%d| in [%d] rozdil", getName(), getYear(), rozdil));
    }

    @Override
    public void pay(double price) {
        System.out.println(String.format("%s Book have price |%f|", getName(), price));

    }



}
