package parkinglot;

import parkinglot.Enums.PaymentStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingTicket  {//implements Comparable {

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

    public static String getCurrentTime() {

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }

    private String generateParkingTicketNumber() {

        ticketNumber++;
        return String.format("%06d", ticketNumber);
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

        exitTime = getCurrentTime();
    }

    public String getExitTime() {

        return exitTime;
    }
}