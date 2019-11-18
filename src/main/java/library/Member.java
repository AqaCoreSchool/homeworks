package library;

import com.github.javafaker.Faker;
import library.common.Common;
import library.common.Constant;
import library.enumeration.BookAuthor;
import library.enumeration.BookGenre;
import library.enumeration.BookLanguage;
import library.enumeration.ProfileStatus;
import library.exception.BookNotFoundException;
import library.exception.GenreNotFoundException;
import library.interfaces.Searchable;
import library.model.Person;

import java.util.*;

public class Member extends Profile implements Searchable {
    private int totalBorrowedBooks;
    private List<BookItem> booksList;

    public Member() {
        booksList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            Faker faker = new Faker();
            String title = faker.book().title();
            BookLanguage language = BookLanguage.randomLanguage();
            BookAuthor author = BookAuthor.randomAuthor();
            int numberOfPages = Common.getRandomNumberInRange(100, 400);
            int releaseDate = Common.getRandomNumberInRange(1950, 2019);
            BookGenre bookGenre = BookGenre.randomGenre();
            booksList.add(new BookItem(title, language, author, numberOfPages, releaseDate, bookGenre));
        }
    }

    public Member(String id, Person person, ProfileStatus profileStatus, int totalBorrowedBooks) {
        super(id, person, profileStatus);
        this.totalBorrowedBooks = totalBorrowedBooks;
    }

    public void borrowBook(BookItem bookItem) {
        if (totalBorrowedBooks >= Constant.MAX_BOOKS_PER_PERSON) {
            System.out.println("Sorry, you can't borrow more than 5 books.");
        }
    }

    public void getAllBooks() {
        for (BookItem item : booksList) {
            System.out.println(item.getTitle() + " : " + item.getAuthor() + " : " + item.getBookGenre() +
                    " : " + item.getReleaseDate() + " : " + item.getLanguage() + " : " + item.getNumberOfPages());
        }
    }

    @Override
    public List<BookItem> getBooksByAuthor(String author) {
        List<BookItem> tempList = new ArrayList<>();
        for (BookItem item : booksList) {
            if (item.getAuthor().toString().contains(author)) {
                tempList.add(item);
                System.out.println(item.getTitle() + " : " + item.getAuthor());
            }
        }
        if (booksList.isEmpty()) {
            try {
                throw new BookNotFoundException("Book list is empty!");
            } catch (BookNotFoundException e) {
                e.printStackTrace();
            }
        }
        return tempList;
    }

    public void sortBooks(List<BookItem> items) {
        Collections.sort(items, new Comparator<BookItem>() {
            @Override
            public int compare(BookItem bookItem, BookItem t1) {
                String title1 = bookItem.getTitle();
                String title2 = t1.getTitle();
                return title1.compareTo(title2);
            }
        });
    }

    public boolean isOneByYear(int year) {
        for (BookItem bookItem : booksList) {
            if (bookItem.getReleaseDate() < year) {
                return true;
            }
        }
        if (booksList.isEmpty()) {
            try {
                throw new BookNotFoundException("Book list is empty!");
            } catch (BookNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean areAllByGenre(BookGenre genre) {
        List<BookItem> tempList = new ArrayList<>();
        for (BookItem book : booksList) {
            if (book.getBookGenre().equals(genre)) {
                tempList.add(book);
            }
        }
        if (tempList.isEmpty()) {
            try {
                throw new GenreNotFoundException("Genre not found!");
            } catch (GenreNotFoundException e) {
                e.printStackTrace();
            }
        }
        return booksList.size() == tempList.size();
    }

    public boolean areNoneByAuthor(String author) {
        List<BookItem> tempList = new ArrayList<>();
        for (BookItem book : booksList) {
            if (!book.getAuthor().toString().contains(author)) {
                tempList.add(book);
            }
        }
        if (booksList.isEmpty()) {
            try {
                throw new BookNotFoundException("Book list is empty!");
            } catch (BookNotFoundException e) {
                e.printStackTrace();
            }
        }
        return booksList.size() == tempList.size();
    }

    List<BookItem> getBooksList() {
        return booksList;
    }

    @Override
    public List<BookItem> getOldestBookPerGenre(List<BookItem> bookItems) {
        Map<String, BookItem> oldestBookByGenre = new HashMap<>();

        for (BookItem bookItem : bookItems) {
            oldestBookByGenre.putIfAbsent(bookItem.getBookGenre().toString(), bookItem);
            if (bookItem.getReleaseDate() < oldestBookByGenre.get(bookItem.getBookGenre().toString()).getReleaseDate()) {
                oldestBookByGenre.put(bookItem.getBookGenre().toString(), bookItem);
            }
        }
        if (booksList.isEmpty()) {
            try {
                throw new BookNotFoundException("Book list is empty!");
            } catch (BookNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>(oldestBookByGenre.values());
    }
}
