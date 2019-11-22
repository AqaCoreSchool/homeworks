package com.company.hw;

public abstract class Library {
    private String bookAuthor;
    private int bookYear;
    private String bookName;
    public boolean available;

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


    public String toString(){
        return String.format("%s <%s> |%d|", bookAuthor, bookName, bookYear);
    }

}
