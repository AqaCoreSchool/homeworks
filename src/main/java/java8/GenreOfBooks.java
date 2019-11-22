package java8;

public enum GenreOfBooks {
    ADWENTURE(0),SCIENCEFICTION(1),HISTORICALFICTION(2),IRELAND(3);
    private int index;
    GenreOfBooks(int index){
        this.index = index;
    }
}
