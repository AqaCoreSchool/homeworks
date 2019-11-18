package library;

import library.enumeration.BookAuthor;
import library.enumeration.BookGenre;
import library.enumeration.BookLanguage;
import library.enumeration.BookStatus;

import java.util.Date;

public class BookItem extends Book {
    private String bookBarCode;
    private String borrowDate;
    private BookStatus status;
    private Date dateOfPurchase;

    public BookItem() {
    }

    public BookItem(String title, String publisher, BookLanguage language, BookAuthor author,
                    int numberOfPages, int releaseDate, BookGenre bookGenre, String bookBarCode, String borrowDate, BookStatus status, Date dateOfPurchase) {
        super(title, language, author, numberOfPages, releaseDate, bookGenre);
        this.bookBarCode = bookBarCode;
        this.borrowDate = borrowDate;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
    }

    public BookItem(String title, BookLanguage language, BookAuthor author,
                    int numberOfPages, int releaseDate, BookGenre bookGenre) {
        super(title, language, author, numberOfPages, releaseDate, bookGenre);
    }

    public String getBookBarCode() {
        return bookBarCode;
    }

    public void setBookBarCode(String bookBarCode) {
        this.bookBarCode = bookBarCode;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}
