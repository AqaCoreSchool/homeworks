package library;

import library.Enum.BookStatus;
import library.Model.Author;

import java.util.Date;
import java.util.List;

public class BookItem extends Book {
    private String bookBarCode;
    private String borrowDate;
    private BookStatus status;
    private Date dateOfPurchase;

    public BookItem(String isbn, String title, String publisher, String language, List<Author> authors,
                    int numberOfPages, String bookBarCode, String borrowDate, BookStatus status,
                    Date dateOfPurchase) {
        super(isbn, title, publisher, language, authors, numberOfPages);
        this.bookBarCode = bookBarCode;
        this.borrowDate = borrowDate;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
    }

    //book operation methods, getters, setters
}
