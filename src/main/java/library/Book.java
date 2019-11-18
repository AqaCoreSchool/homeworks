package library;

import library.enumeration.BookAuthor;
import library.enumeration.BookGenre;
import library.enumeration.BookLanguage;

public abstract class Book {
    private String title;
    private int numberOfPages;
    private int releaseDate;
    private BookGenre bookGenre;
    private BookLanguage language;
    private BookAuthor author;

    public Book(String title, BookLanguage language, BookAuthor author, int numberOfPages,
                int releaseDate, BookGenre bookGenre) {
        this.title = title;
        this.language = language;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.releaseDate = releaseDate;
        this.bookGenre = bookGenre;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookLanguage getLanguage() {
        return language;
    }

    public void setLanguage(BookLanguage language) {
        this.language = language;
    }

    public BookAuthor getAuthor() {
        return author;
    }

    public void setAuthor(BookAuthor author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }
}
