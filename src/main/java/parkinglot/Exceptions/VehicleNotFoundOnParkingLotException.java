package parkinglot.Exceptions;

public class VehicleNotFoundOnParkingLotException extends RuntimeException {
    public VehicleNotFoundOnParkingLotException(String message) {
        super(message);
    }
}
