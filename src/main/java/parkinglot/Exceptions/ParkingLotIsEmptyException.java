package parkinglot.Exceptions;

public class ParkingLotIsEmptyException extends RuntimeException {
    public ParkingLotIsEmptyException(String message) {
        super(message);
    }
}
