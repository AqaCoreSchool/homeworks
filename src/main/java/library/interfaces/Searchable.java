package library.interfaces;

import library.BookItem;

import java.util.List;

public interface Searchable {
    List<BookItem> getOldestBookPerGenre(List<BookItem> bookItems);
    void printBooksByAuthor(String author);
    //... other methods
}
