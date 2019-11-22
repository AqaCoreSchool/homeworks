package com.company.hw;

import com.company.hw.books.Comics;
import com.company.hw.books.Encyclopedia;
import com.company.hw.books.Novel;
import com.company.hw.exceptions.NoSuchBookException;
import com.company.hw.sort.BookComparator;
import com.company.hw.sort.YearComparator;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;


public class User {

    private List < Library > books;
    private LocalDate date = LocalDate.now();

    private Novel novelExample = new Novel("Example", "Example", 2019, 3, false);
    private Comics comicsExample = new Comics("Example", "Example", 2019, true);
    private Encyclopedia encyclopediaExample = new Encyclopedia("Example", "Example", 2012, true);


    User() {
        books = new ArrayList < > ();
        books.add(new Novel("N. Pidmogylnuy", "City", 1920, 3, false));
        books.add(new Novel("M. Zerov", "Incognito", 1918, 3, false));
        books.add(new Novel("B. Voronnuy", "Infanta", 1904, 3, true));
        books.add(new Novel("E. Bronte", "Glass Town", 1827, 5, true));
        books.add(new Novel("E. Bronte", "Wuthering Heights", 1847, 5, true));
        books.add(new Novel("W. Shakespeare", "Gamlet", 1603, 1, false));
        books.add(new Novel("T. Shevchenko", "B", 1865, 5, true));
        books.add(new Novel("T. Shevchenko", "A", 1845, 5, true));
        books.add(new Novel("T. Shevchenko", "C", 2019, 5, true));

        books.add(new Comics("A. Chornuy", "Fly", 2019, true));
        books.add(new Comics("K. Dankovych", "My life", 2017, false));
        books.add(new Comics("H. Nazarov", "Green door of Earth", 2018, false));
        books.add(new Comics("L. Poznyak", "Family", 1992, true));

        books.add(new Encyclopedia("O. Bilyk", "Anatomy", 2012, true));
        books.add(new Encyclopedia("P. Ivanov", "Ukrainian World", 2010, false));
        books.add(new Encyclopedia("M. Orlyk", "The World Of Us", 2017, false));
        books.add(new Encyclopedia("A. Kvadrat", "Geometry", 2001, true));
        books.add(new Encyclopedia("Y. Bachynskyi", "Irredenta", 1920, false));
        books.add(new Encyclopedia("A. Figure", "Universe of Algebra", 2011, true));

    }



    //1
    void printAvailableBooks() {
        LocalDate lastDay =
                date.with(TemporalAdjusters.lastDayOfMonth());
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String formatedDateTime = lastDay.format(format);
        books.stream()
                .filter(element -> element.available)
                .forEach(element -> System.out.println(String.format("%s available till %s", element, formatedDateTime)));
    }


    //2
    void filterBooksByAuthor(String author) {
        List < Library > tempList = new ArrayList < > ();
        books.stream()
                .filter(element -> element.available && element.getAuthor().contains(author))
                .forEach(element -> tempList.add(element));

        tempList.stream().forEach(element -> System.out.println(element));

        if (tempList.isEmpty()) {
            throw new NoSuchBookException("We don't have any Books by this Author");
        }
    }

    //3
    void sortAlpabetically() {
        books.sort(new BookComparator());
        books.stream().forEach(element -> System.out.println(element));
    }

    //4
    void findEarlierBooks(int year) {
        LocalDate yearDate = date.withYear(year);
        LocalDate specificDate =
                yearDate.minus(3, ChronoUnit.YEARS);
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formatedDate = specificDate.format(format);
        books.stream().filter(element -> element.getYear() < year).forEach(book -> System.out.println(String.format("Library get %s in %s", book, formatedDate)));
    }

    //5
    void checkGenre(String genre) {
        List < Library > tempList = new ArrayList < > ();
        books.stream().filter(element -> element.getClass().toString().contains(genre)).forEach(tempList::add);
        System.out.println(tempList);

        if (tempList.isEmpty()) {
            System.out.println("The last book was brought in " + date);
            throw new NoSuchBookException("We don't have books in this Genre");
        }

    }


    //6
    boolean hasNoneBooksByAuthor(String author) {
        final Optional < Library > optionalBook = books.stream()
                .filter(element -> element.getAuthor().contains(author))
                .findFirst();
        return !optionalBook.isPresent();
    }

    //7
    void printFilteredBooksByGenre() {
        List < Library > listOfNovel = new ArrayList < > ();
        List < Library > listOfComics = new ArrayList < > ();
        List < Library > listOfEncyclopedia = new ArrayList < > ();
        List < Library > tempList = new ArrayList < > ();
        for (Library element: books) {
            if (element.getClass().equals(novelExample.getClass())) {
                listOfNovel.add(element);
                listOfNovel.sort(new YearComparator());

            } else if (element.getClass().equals(comicsExample.getClass())) {
                listOfComics.add(element);
                listOfComics.sort(new YearComparator());

            } else if (element.getClass().equals(encyclopediaExample.getClass())) {
                listOfEncyclopedia.add(element);
                listOfEncyclopedia.sort(new YearComparator());
            }
        }
        try {
            tempList.add(listOfNovel.stream().skip(0).findFirst().get());
            tempList.add(listOfComics.stream().skip(0).findFirst().get());
            tempList.add(listOfEncyclopedia.stream().skip(0).findFirst().get());
            tempList.sort(new BookComparator());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Hey, we don't have any Books now!");
        }

        String chString = tempList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(chString);

    }

    void useMap() {
        HashMap < StringBuilder, Library > bookMap = new HashMap < > ();
        for (int i = 0; i <= 18; i++) {
            Faker faker = new Faker();
            final StringBuilder isbn = new StringBuilder()
                    .append(faker.expression("#{code.isbn_gs1}"))
                    .append('-')
                    .append(faker.expression("#{code.isbn_group}"))
                    .append('-')
                    .append(faker.expression("#{code.isbn_registrant}"));

            int startIndex = 0;
            int endIndex = 10;
            char[] buffer = new char[endIndex - startIndex];
            isbn.getChars(0, 9, buffer, 0);

            try {
                bookMap.put(isbn, books.get(i));
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Hey, we don't have any Books now!");
            }
        }

        bookMap.entrySet().stream().map(entry -> entry.getKey() + " = " + entry.getValue()).forEach(System.out::println);
    }



}