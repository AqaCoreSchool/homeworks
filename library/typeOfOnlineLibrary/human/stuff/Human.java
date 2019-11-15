package library.typeOfOnlineLibrary.people.stuff;

public abstract class Human {
    protected String name;
    protected boolean isMale;
    private double salary;

    void doWork(){}
    void setSalary(double salary){
        this.salary = salary;
    }

    abstract protected void setName(String name);
    abstract protected void setGender(boolean sex);
}
