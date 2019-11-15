package library.book;

public enum VereficatiionCriteria {
    GENRE(0),AUTHOR(1),YEAR(2);
    public final int number;

    private VereficatiionCriteria(int number) {
        this.number = number;
    }
}
