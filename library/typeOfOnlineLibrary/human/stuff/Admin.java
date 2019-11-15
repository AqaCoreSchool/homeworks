package library.typeOfOnlineLibrary.people.stuff;

public class Admin extends Human {
    @Override
    protected void setName(String name) {
        this.name = name;
    }

    @Override
    protected void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    @Override
    public void doWork(){

    }
    @Override
    void setSalary(double salary) {
        super.setSalary(salary);
    }


    protected  void dowork(Admin admin, Librarian librarian, CleanerMananger cleanerMananger,
                              Guardian guardian, Seller seller){
        //hire personals
    }

    protected  void dowork(Admin admin, Librarian librarian, CleanerMananger cleanerMananger,
                              Guardian guardian){
        //hire personals
    }

    protected  void dowork(Admin admin, Librarian librarian, CleanerMananger cleanerMananger,
                              Seller seller){
        //hire personals
    }

    protected  void dowork(Admin admin, Librarian librarian, CleanerMananger cleanerMananger){
        //hire personals
    }
}
