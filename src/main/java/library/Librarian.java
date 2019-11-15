package library;

import library.interfaces.Searchable;
import library.model.Person;

import java.util.List;

public class Librarian extends Profile implements Searchable {

    public Librarian(String id, Person person) {
        super(id, person);
    }

    public void addBookItem(BookItem bookItem) {

    }

    public void removeBookItem(BookItem bookItem) {

    }

    public void editBookItem(BookItem bookItem) {

    }

    public void banUser(Member member) {

    }
    public void unbanUser(Member member) {

    }

    public List<Book> searchBookByTitle(String title) {
        return null;
    }

    public List<Book> searchBookByAuthor(String author) {
        return null;
    }
}
