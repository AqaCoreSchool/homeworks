package parking;

public class NumberNullPointerException extends RuntimeException {
    public NumberNullPointerException(String message) {
        System.out.println("Number is empty. You can not add vehicle without number ");
    }

}
