package parkinglot;

import java.util.Date;

public class ParkingTicket {

    private String parkingTicketNumber;
    private String paymentStatus;
    private String entranceTime;
    private String exitTime;

    private static int ticketNumber = 0;

    ParkingTicket() {
        this.paymentStatus = PaymentStatus.UNPAYED.toString();
        this.entranceTime = getCurrentTime();
        this.parkingTicketNumber = generateParkingTicketNumber();
        this.exitTime = "";
    }

    private String getCurrentTime() {
        Date date = new Date();
        return date.toString();
    }

    private String generateParkingTicketNumber() {
        ticketNumber++;
        return String.format("%06d",ticketNumber);
    }

    public String getParkingTicketNumber() {

        return parkingTicketNumber;
    }

    public String getEntranceTime() {

        return entranceTime;
    }

    public String getPaymentStatus() {

        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setExitTime() {
        this.exitTime = getCurrentTime();
    }

    public String getExitTime() {
        return exitTime;
    }

}
