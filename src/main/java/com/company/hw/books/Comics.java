package com.company.hw.books;

import com.company.hw.Library;
import com.company.hw.interfaces.Artistic;

public class Comics extends Library implements Artistic {

    public Comics(String author, String name, int year, boolean avail) {
        super(author, name, year, avail);
    }

    @Override
    public void isArtisticType(boolean isArtistic) {
        if (!isArtistic) {
            System.out.println("Our comics must be artistic! You need to change type");
        } else {
            System.out.println("Our comics is artistic!");
        }
    }

}