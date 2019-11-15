package library.typeOfOnlineLibrary.people.stuff;

public class CleanerMananger extends Human {

    @Override
    void doWork() {
        // clean floor
    }

    @Override
    void setSalary(double salary) {

        super.setSalary(salary);
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
