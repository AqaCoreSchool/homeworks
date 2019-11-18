package library.book.structure.typeOfOnlineLibrary.people.stuff;

public abstract class People {
    protected String name;
    protected boolean sex;
    private long salary;

    void doWork(){}
    void setSalary(){}

    abstract protected void setName(String name);
    abstract protected void setSex(boolean sex);
}
