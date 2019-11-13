package hw3;

public class Encyclopedia  extends Library implements NotArtistic {

    Encyclopedia(String author, String name, int year, boolean avail){
        super(author, name, year, avail);
    }

    @Override
    public void inform() {
        System.out.println(String.format("Encyclopedia %s from |%d|", getAuthor(), getYear()));
    }

    @Override
    public void pay(double price) {
        System.out.println(String.format("%s Book have price |%f|", getAuthor(), price*20));

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
    public void howMuchPages(int pages) {
        if(pages > 1000){
            System.out.println(String.format("Woow. This really big %s with |%d| pages", getAuthor(), pages));
        }
        else {
            System.out.println(String.format("This %s have only |%d|. You can do it!", getAuthor(), pages));
        }
    }
}
