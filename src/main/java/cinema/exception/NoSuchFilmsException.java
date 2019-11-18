package cinema.exception;


public class NoSuchFilmsException extends RuntimeException {
    public NoSuchFilmsException(String message) {
        super(message);
    }
}
