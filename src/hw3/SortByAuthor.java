package hw3;


import java.util.Comparator;

public class SortByAuthor implements Comparator<Library>
{
    public int compare(Library a, Library b)
    {
        return a.getAuthor().substring(3).compareTo(b.getAuthor().substring(3));
    }

}
