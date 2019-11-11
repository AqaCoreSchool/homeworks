package library;

import library.Enum.ReservationStatus;

public class BookReservation {
    private String creationDate;
    private String memberId;
    private String bookItemBarCode;
    private ReservationStatus reservationStatus;

    public BookReservation(String creationDate, String memberId, String bookItemBarCode, ReservationStatus reservationStatus) {
        this.creationDate = creationDate;
        this.memberId = memberId;
        this.bookItemBarCode = bookItemBarCode;
        this.reservationStatus = reservationStatus;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookItemBarCode() {
        return bookItemBarCode;
    }

    public void setBookItemBarCode(String bookItemBarCode) {
        this.bookItemBarCode = bookItemBarCode;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public static BookReservation getReservationDetails(String bookItemBarCode) {
        return null;
    }

    @Override
    public String toString() {
        return "BookReservation{" +
                "creationDate='" + creationDate + '\'' +
                ", memberId='" + memberId + '\'' +
                ", bookItemBarCode='" + bookItemBarCode + '\'' +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
