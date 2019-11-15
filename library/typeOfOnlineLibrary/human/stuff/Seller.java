package library.typeOfOnlineLibrary.people.stuff;

public class Seller extends Human {

    @Override
    void doWork() {
        //sell products
    }


    @Override
    void setSalary(double salary) {
        super.setSalary( salary );
    }

    @Override
    protected void setName(String name) {
        this.name = name;
    }

    @Override
    protected void setGender(boolean isMale) {
        this.isMale = isMale;
    }
}
