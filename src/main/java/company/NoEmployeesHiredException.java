package company;

public class NoEmployeesHiredException extends  RuntimeException {
    public NoEmployeesHiredException(String message) {
        super(message);
    }
}
