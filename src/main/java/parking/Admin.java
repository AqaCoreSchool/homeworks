package parking;

public class Admin extends AbstractEmployees {

    public Admin() {
        standard();
    }

    public Admin(String name, int workHours) {
        super(name, workHours);
        standard();
    }

    @Override
    public void standard() {
        this.setRatePerHour(100);
        this.setPosition("Admin");
    }

}
