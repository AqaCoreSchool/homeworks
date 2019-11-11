package library.Interface;

import library.Book;
import java.util.List;

public interface Searchable {
    List<Book> searchBookByTitle(String title);
    List<Book> searchBookByAuthor(String author);
    //... other methods
}
