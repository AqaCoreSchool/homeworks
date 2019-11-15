package library;

import library.common.Constant;
import library.enumeration.ProfileStatus;
import library.interfaces.Searchable;
import library.model.Person;

import java.util.List;

public class Member extends Profile implements Searchable {
    private int totalBorrowedBooks;

    public Member(String id, Person person, ProfileStatus profileStatus, int totalBorrowedBooks) {
        super(id, person, profileStatus);
        this.totalBorrowedBooks = totalBorrowedBooks;
    }

    public void borrowBook(BookItem bookItem) {
        if (totalBorrowedBooks >= Constant.MAX_BOOKS_PER_PERSON) {
            System.out.println("Sorry, you can't borrow more than 5 books.");
        }
    }

    public void returnBook(BookItem bookItem) {

    }

    public List<Book> searchBookByTitle(String title) {
        return null;
    }

    public List<Book> searchBookByAuthor(String author) {
        return null;
    }
}
