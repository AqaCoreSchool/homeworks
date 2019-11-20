package library;

import com.github.javafaker.Faker;
import library.common.Common;
import library.common.Constant;
import library.enumeration.BookAuthor;
import library.enumeration.BookGenre;
import library.enumeration.BookLanguage;
import library.enumeration.ProfileStatus;
import library.exception.BookNotFoundException;
import library.interfaces.Searchable;
import library.model.Person;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class Member extends Profile implements Searchable {
    private int totalBorrowedBooks;
    private List<BookItem> booksList = new ArrayList<>();

    public Member() {
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
    public void printBooksByAuthor(String author) {
        List<BookItem> tempList = new ArrayList<>();
        if (booksList.isEmpty()) {
            throw new BookNotFoundException("Book list is empty!");
        }
        booksList.stream()
                .filter(name -> name.getAuthor().toString().contains(author))
                .forEach(tempList::add);
        tempList.forEach(bookItem -> System.out.format("%s : %s%n", bookItem.getTitle(), bookItem.getAuthor()));
    }

    public void sortBooks(List<BookItem> items) {
        items.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(bookItem -> System.out.println(bookItem.getTitle()));
    }

    public boolean isOneByYear(int year) {
        if (booksList.isEmpty()) {
            throw new BookNotFoundException("Book list is empty!");
        }
        return booksList.stream()
                .anyMatch(bookItem -> bookItem.getReleaseDate() < year);
    }

    public boolean areAllByGenre(String genre) {
        if (booksList.isEmpty()) {
            throw new BookNotFoundException("Book list is empty!");
        }
        return booksList.stream()
                .allMatch(bookItem -> bookItem.getBookGenre().toString().contains(genre));
    }

    public boolean areNoneByAuthor(String author) {
        if (booksList.isEmpty()) {
            throw new BookNotFoundException("Book list is empty!");
        }
        return booksList.stream()
                .noneMatch(bookItem -> bookItem.getAuthor().toString().contains(author));
    }

    List<BookItem> getBooksList() {
        return booksList;
    }

    @Override
    public List<BookItem> getOldestBookPerGenre(List<BookItem> bookItems) {
        Map<String, BookItem> map = new HashMap<>();
        if (booksList.isEmpty()) {
            throw new BookNotFoundException("Book list is empty!");
        }
        for (BookItem bookItem : bookItems) {
            map.putIfAbsent(bookItem.getBookGenre().toString(), bookItem);
            if (bookItem.getReleaseDate() < map.get(bookItem.getBookGenre().toString()).getReleaseDate()) {
                map.put(bookItem.getBookGenre().toString(), bookItem);
            }
        }
        return new ArrayList<>(map.values());
    }

    public void printLibraryWorkingTime() {
        ZoneId zone = ZoneId.systemDefault();
        LocalDate today = LocalDate.now(zone);
        LocalTime tenAM = LocalTime.of(10,0);
        LocalTime nineteenPM = LocalTime.of(19,0);
        ZonedDateTime startWorking = today.atTime(tenAM).atZone(zone);
        ZonedDateTime finishWorking = today.atTime(nineteenPM).atZone(zone);
        String currentTime = LocalTime.now(zone).toString();
        System.out.format("The time is: %s%n", currentTime);
        ZonedDateTime timeDifference = today.atTime(LocalTime.parse(currentTime)).atZone(zone);
        if (startWorking.isAfter(timeDifference) || finishWorking.isBefore(timeDifference)) {
            System.out.println("Library is currently closed. Working hours: 10:00 - 19:00");
        }
        else {
            System.out.println("Library is currently opened");
        }

    }
}
