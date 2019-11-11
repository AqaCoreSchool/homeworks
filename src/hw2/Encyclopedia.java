package hw2;

public class Encyclopedia  extends Library implements NotArtistic {
    private String current_author;
    private int current_year;

    Encyclopedia(String a, int y) {
        super(a, y);
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
    public void inform() {
        System.out.println(String.format("Encyclopedia %s from |%d|", getName(), getYear()));
    }

    @Override
    public void pay(double price) {
//        System.out.println("Name is " + getName() + ". Cost is " + price*20);
        System.out.println(String.format("%s Book have price |%f|", getName(), price*20));

    }

    @Override
    public void noTyping(boolean type) {
        if (!type) {
            System.out.println("Our Encyclopedia must be artistic! You need to change type");
        } else {
            System.out.println("Our Encyclopedia isn't artistic! You are right");
        }
    }

    @Override
    public void how_much_pages(int pages) {
        if(pages > 1000){
            System.out.println(String.format("Woow. This really big %s with |%d| pages", getName(), pages));
        }
        else {
            System.out.println(String.format("This %s have only |%d|. You can do it!", getName(), pages));
        }
    }
}
