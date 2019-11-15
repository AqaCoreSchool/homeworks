public class Book {
    private String name;
    private String author;
    private String genre;
    private int size;
    Book(){}
    Book(String name,String author,String genre,int size){
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.size = size;
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

    public int getSize() {
        return size;
    }
}
