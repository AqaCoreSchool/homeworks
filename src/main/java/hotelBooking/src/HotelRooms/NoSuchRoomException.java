package hotelRooms;

public class NoSuchRoomException extends RuntimeException {

    public NoSuchRoomException(String message){
        super(message);
    }
}
