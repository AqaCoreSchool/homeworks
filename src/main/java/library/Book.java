package library;

import library.Model.Author;

import java.util.List;

public abstract class Book {
    private String isbn;
    private String title;
    private String publisher;
    private String language;
    private List<Author> authors;
    private int numberOfPages;

    public Book(String isbn, String title, String publisher, String language, List<Author> authors, int numberOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.language = language;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
    }

    //getters, setters
}
