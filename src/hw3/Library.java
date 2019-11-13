package hw3;


abstract class Library {
    private String bookAuthor;
    private int bookYear;
    private String bookName;
    boolean available;


    protected abstract void inform();
    public abstract void pay(double price);

    Library(String author, String name, int year, boolean avail){
        bookAuthor = author;
        bookName = name;
        bookYear = year;
        available = avail;
    }

    String getAuthor() {
        return bookAuthor;
    }
    String getBookName(){return bookName;}

    int getYear() {
        return bookYear;
    }

    public String toString(){
        return String.format("%s <%s> |%d|", bookAuthor, bookName, bookYear);
    }

}
