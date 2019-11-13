package hw3;
import java.util.Comparator;

public class SortByYear implements Comparator<Library> {
    public int compare(Library a, Library b) {
        return a.getYear() - b.getYear();
    }
}
