package parkinglot.Exceptions;

public class ParkingTicketNumberNotFoundException extends RuntimeException {
    public ParkingTicketNumberNotFoundException(String message) {
        super(message);
    }
}
