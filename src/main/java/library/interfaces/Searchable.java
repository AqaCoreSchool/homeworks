package library.interfaces;

import library.BookItem;

import java.util.List;

public interface Searchable {
    List<BookItem> getOldestBookPerGenre(List<BookItem> bookItems);
    List<BookItem> getBooksByAuthor(String author);
    //... other methods
}
