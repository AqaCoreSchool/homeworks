package eight.exception;

public class NoSuchGenreException extends IllegalArgumentException {
    public NoSuchGenreException(String message) {
        super(message);
    }
}
