package library.book.structure;

public abstract class Library {
    protected String address;
    protected String name;
    protected long countOfBooks;
    protected byte permissionLevel;


    protected  abstract void workWithCustomer();


}
