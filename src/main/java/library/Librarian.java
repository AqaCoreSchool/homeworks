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

    @Override
    public List<BookItem> getOldestBookPerGenre(List<BookItem> bookItems) {
        return null;
    }

    @Override
    public List<BookItem> getBooksByAuthor(String author) {
        return null;
    }
}
