package lk.ijse.libraryManagementSystem.view.tm;

public class BookTM {
    private String bookID;
    private String bookTitle;
    private String author;
    private String publisher;

    public BookTM() {
    }

    public BookTM(String bookID, String bookTitle, String author, String publisher, String bookIntCode) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.bookIntCode = bookIntCode;
    }

    private String bookIntCode;

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBookIntCode() {
        return bookIntCode;
    }

    public void setBookIntCode(String bookIntCode) {
        this.bookIntCode = bookIntCode;
    }
}
