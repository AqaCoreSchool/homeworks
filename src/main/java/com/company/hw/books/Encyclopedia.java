package com.company.hw.books;

import com.company.hw.Library;
import com.company.hw.interfaces.NotArtisticable;

public class Encyclopedia extends Library implements NotArtisticable {

    public Encyclopedia(String author, String name, int year, boolean avail) {
        super(author, name, year, avail);
    }

    @Override
    public void isNotArtisticType(boolean isArtistic) {
        if (!isArtistic) {
            System.out.println("Our Encyclopedia must be artistic! You need to change type");
        } else {
            System.out.println("Our Encyclopedia isn't artistic! You are right");
        }
    }

    @Override
    public int getNumberOfPages(int pages) {
        if (pages > 1000) {
            System.out.println(String.format("Woow. This really big %s with |%d| pages", getAuthor(), pages));
        } else {
            System.out.println(String.format("This %s have only |%d|. You can do it!", getAuthor(), pages));
        }
        return pages;
    }
}
