package exceptions;

public class NoSuchRoomException extends RuntimeException  {
    public NoSuchRoomException(String m){
        super(m);
    }
}
