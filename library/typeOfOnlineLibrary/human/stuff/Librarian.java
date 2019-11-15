package library.typeOfOnlineLibrary.people.stuff;

public class Librarian extends Human {
    @Override
    protected void setName(String name) {
        this.name = name;
    }

    @Override
    protected void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    @Override
    public void doWork() {

    }

    @Override
    protected void setSalary(double salary) {
        super.setSalary( salary );
    }


    protected void doWork(String nameOfBook) {
        //take book
    }

    protected void doWork(String nameOfBook, String readerCard) {
       //give book

    }

    protected void doWork(String nameOfBook, String readerCard,Integer suma) {
       // make fine
    }
}
