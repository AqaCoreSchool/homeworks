package library.exception;

public class GenreNotFoundException extends RuntimeException {
    public GenreNotFoundException(String msg) {
        super(msg);
    }
}
