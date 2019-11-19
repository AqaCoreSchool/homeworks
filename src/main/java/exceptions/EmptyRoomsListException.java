package exceptions;

public class EmptyRoomsListException extends RuntimeException {
    public EmptyRoomsListException(String m){
        super(m);
    }
}
