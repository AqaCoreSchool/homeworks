package collections;

public class WorkWithBookException extends Exception {
    public WorkWithBookException() {
        super();
    }

    public WorkWithBookException(String message) {
        super( message );
    }

    public WorkWithBookException(String message, Throwable cause) {
        super( message, cause );
    }

    public WorkWithBookException(Throwable cause) {
        super( cause );
    }

    protected WorkWithBookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
