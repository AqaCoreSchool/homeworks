package hw3;


import java.util.Comparator;
public class SortByBook implements Comparator<Library> {
    public int compare(Library a, Library b) {
        return a.getBookName().compareTo(b.getBookName());
    }
}



