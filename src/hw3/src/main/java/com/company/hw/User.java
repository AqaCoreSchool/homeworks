package com.company.hw;

import com.company.hw.books.Comics;
import com.company.hw.books.Encyclopedia;
import com.company.hw.books.Novel;
import com.company.hw.sort.SortByBook;
import com.company.hw.sort.SortByYear;
import com.github.javafaker.Faker;

import java.util.*;

public class User {

    private List<Library> books;

    Novel novelExample = new Novel("Example", "Example", 2019, 3, false);
    Comics comicsExample = new Comics("Example", "Example", 2019, true);
    Encyclopedia encyclopediaExample = new Encyclopedia("Example", "Example", 2012, true);

    User() {
        books = new ArrayList<>();
        books.add(new Novel("N. Pidmogylnuy", "City", 1920, 3, false));
        books.add(new Novel("M. Zerov", "Incognito", 1918, 3, false));
        books.add(new Novel("B. Voronnuy", "Infanta", 1904, 3, true));
        books.add(new Novel("E. Bronte", "Glass Town", 1827, 5, true));
        books.add(new Novel("E. Bronte", "Wuthering Heights", 1847, 5, true));
        books.add(new Novel("W. Shakespeare", "Gamlet", 1603, 1, false));
        books.add(new Novel("T. Shevchenko", "B", 2020, 5, true));
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
    void getAvailableBooks() {
        for (Library element : books) {
            if (element.available) {
                System.out.println(element);
            }
        }
    }

    //2
    void getFilteredByAuthor(String author) {
        List<Library> tempList = new ArrayList<>();
        for (Library element : books) {
            if (element.available && element.getAuthor().contains(author)) {
                tempList.add(element);
                tempList.sort(new SortByBook());
            }
        }
        System.out.println(tempList);
    }

    //3
    void sortAlpabetically() {
        books.sort(new SortByBook());
        for (Library element : books) {
            System.out.println(element);
        }
    }

    //4
    boolean hasEarlierBooks(int year) {
        for (Library next : books) {
            if (next.getYear() < year) {
                return true;
            }
        }
        return false;
    }

    //5
    boolean checkGenre(String genre) {
        for (Library next : books) {
            if (next.getClass().toString().contains(genre)) {
                return true;
            }
        }
        return false;
    }

    //6
    boolean hasNotBooksByAuthor(String author) {
        List<Library> tempList = new ArrayList<>();
        for (Library next : books) {
            if (!next.getAuthor().contains(author)) {
                tempList.add(next);
            }
        }
        return books.size() == tempList.size();
    }

    //7
    void filteredByGenre() {
        List<Library> listOfNovel = new ArrayList<>();
        List<Library> listOfComics = new ArrayList<>();
        List<Library> listOfEncyclopedia = new ArrayList<>();
        List<Library> tempList = new ArrayList<>();
        for (Library element : books) {
            if (element.getClass().equals(novelExample.getClass())) {
                listOfNovel.add(element);
                listOfNovel.sort(new SortByYear());

            } else if (element.getClass().equals(comicsExample.getClass())) {
                listOfComics.add(element);
                listOfComics.sort(new SortByYear());

            } else if (element.getClass().equals(encyclopediaExample.getClass())) {
                listOfEncyclopedia.add(element);
                listOfEncyclopedia.sort(new SortByYear());
            }
        }
        tempList.add(listOfNovel.get(0));
        tempList.add(listOfComics.get(0));
        tempList.add(listOfEncyclopedia.get(0));
        tempList.sort(new SortByBook());

        String commaDelimitr = String.join(" , ", tempList.get(0).toString(), tempList.get(1).toString(), tempList.get(2).toString());
        System.out.println(commaDelimitr);
    }

    void useMap() {
        HashMap<StringBuilder, Library> bookMap = new HashMap<>();
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

            bookMap.put(isbn, books.get(i));
        }
        for (Map.Entry<StringBuilder, Library> entry : bookMap.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());
    }


}








