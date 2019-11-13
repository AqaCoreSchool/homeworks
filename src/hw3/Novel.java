package hw3;


public class Novel extends Library implements Artistic {
     private int rozdil;

    Novel(String author, String name, int year, int r, boolean avail){
        super(author, name, year, avail);
        rozdil = r;
        available = avail;
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
        System.out.println(String.format("Novel %s from |%d| in [%d] rozdil", getAuthor(), getYear(), rozdil));
    }

    @Override
    public void pay(double price) {
        System.out.println(String.format("%s Book have price |%f|", getAuthor(), price));

    }
}
