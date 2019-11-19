package com.company.hw;

public abstract class Library {
    private String bookAuthor;
    private int bookYear;
    private String bookName;
    boolean available;

    public Library(String author, String name, int year, boolean avail){
        bookAuthor = author;
        bookName = name;
        bookYear = year;
        available = avail;
    }


    public String getAuthor() {
        return bookAuthor;
    }
    public String getBookName(){return bookName;}
    public int getYear() {
        return bookYear;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String toString(){
        return String.format("%s <%s> |%d|", bookAuthor, bookName, bookYear);
    }

}
