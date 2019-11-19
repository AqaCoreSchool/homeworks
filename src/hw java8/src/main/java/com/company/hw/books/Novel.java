package com.company.hw.books;

import com.company.hw.Library;
import com.company.hw.interfaces.Artistic;

public class Novel extends Library implements Artistic {
    private int rozdil;

    public Novel(String author, String name, int year, int r, boolean avail){
        super(author, name, year, avail);
        rozdil = r;
    }

    @Override
    public void typing(boolean type) {
        if (!type) {
            System.out.println("Our novel must be artistic maybe?");
        } else {
            System.out.println("Our novel is artistic!");
        }
    }

}
