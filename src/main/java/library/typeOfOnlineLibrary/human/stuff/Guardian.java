package library.typeOfOnlineLibrary.people.stuff;

public class Guardian extends Human {
    @Override
    void doWork() {

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
