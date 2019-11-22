package com.company.hw.books;

import com.company.hw.Library;
import com.company.hw.interfaces.Artistic;

public class Novel extends Library implements Artistic {
    private int chapter;

    public Novel(String author, String name, int year, int novelChapter, boolean avail) {
        super(author, name, year, avail);
        chapter = novelChapter;
    }

    @Override
    public void isArtisticType(boolean isArtistic) {
        if (!isArtistic) {
            System.out.println("Our novel must be artistic maybe?");
        } else {
            System.out.println("Our novel is artistic!");
        }
    }

}