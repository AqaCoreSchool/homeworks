package java8;

public class Book {
   final private String name;
    private String author;
    private String genre;
   final private  int year ;


    public Book(String name, String author, String genre, int year) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }



    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }



    public int getYear() {
        return year;
    }




    @Override
    public int hashCode() {
        int code =0;
        char elementsForeHash[] = name.toCharArray();
        for (int i = 0; i <elementsForeHash.length ; i++) {
           code += elementsForeHash[i];
        }
        return code*year;
    }
}
