package library;

import com.github.javafaker.Faker;
import library.common.Common;
import library.enumeration.BookAuthor;
import library.enumeration.BookGenre;
import library.enumeration.BookLanguage;

import java.util.*;

public class Template {

    private List<BookItem> booksList;
    private Map<Integer, String> map;
    //List<BookItem> tempList = new ArrayList<>();


    Template() {
        booksList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
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

    void getAllAvailableBooks() {
        for (BookItem item : booksList) {
            System.out.println(item.getTitle() + " : " + item.getAuthor() + " : " + item.getBookGenre() +
                    " : " + item.getReleaseDate() + " : " + item.getLanguage() + " : " + item.getNumberOfPages());
        }
    }

   List<BookItem> getBooksByAuthor(String author) {
        List<BookItem> tempList = new ArrayList<>();
        for (BookItem item : booksList) {
            if (item.getAuthor().toString().contains(author)) {
                tempList.add(item);
                System.out.println(item.getTitle() + " : " + item.getAuthor());
            }
        }
        return tempList;
   }

   void sortBooks(List<BookItem> items) {
        Collections.sort(items, new Comparator<BookItem>() {
            @Override
            public int compare(BookItem bookItem, BookItem t1) {
                String title1 = bookItem.getTitle();
                String title2 = t1.getTitle();
                return title1.compareTo(title2);
            }
        });
   }

    boolean checkOneByYear(int year) {
       for (BookItem bookItem : booksList) {
           if (bookItem.getReleaseDate() < year) {
               return true;
           }
       }
       return false;
    }

    boolean checkAllByGenre(BookGenre genre) {
        List<BookItem> tempList = new ArrayList<>();
        for (BookItem book : booksList) {
            if (book.getBookGenre().equals(genre)) {
                tempList.add(book);
            }
        }
        return booksList.size() == tempList.size();
    }

    boolean checkAllByAuthor(String author) {
        List<BookItem> tempList = new ArrayList<>();
        for (BookItem book : booksList) {
            if (!book.getAuthor().toString().contains(author)) {
                tempList.add(book);
            }
        }
        return booksList.size() == tempList.size();
    }

    List<BookItem> getBooksList() {
        return booksList;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    //Task 7.Currently not working. I will fix it asap.
    /*List<BookItem> printOldestBookPerEachGenre(List<BookItem> bookItems) {
        List<BookItem> resultList = new ArrayList<>();
        for (int i = 0; i < BookGenre.values().length; i++) {
            for (BookItem bookItem : bookItems) {
                if (bookItem.getBookGenre().ordinal() == i) {
                    tempList.add(bookItem);
                }
            }
            tempList.sort(new Comparator<BookItem>() {
                @Override
                public int compare(BookItem bookItem, BookItem t1) {
                    Integer year = bookItem.getReleaseDate();
                    Integer year2 = t1.getReleaseDate();
                    return year.compareTo(year2);
                }
            });
            resultList.add(tempList.get(0));
            sortBooks(resultList);
        }
        return resultList;
    }*/

    Map putValuesInMap(List<BookItem> bookItems) {
        map = new HashMap<>();
        for (BookItem item : booksList) {
            map.put(item.getReleaseDate(), item.getTitle());
        }
        return map;
    }
}
