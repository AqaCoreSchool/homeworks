package com.company.hw.sort;

import com.company.hw.Library;

import java.util.Comparator;
public class SortByBook implements Comparator<Library> {
    public int compare(Library a, Library b) {
        return a.getBookName().compareTo(b.getBookName());
    }
}