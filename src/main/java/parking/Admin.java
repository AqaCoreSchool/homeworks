package parking;

public class Admin extends AbstractEmployee {

    public Admin() {
        setDefaultValuesEmployee();
    }

    public Admin(String name, int workHours) {
        super(name, workHours);
        setDefaultValuesEmployee();
    }

    @Override
    public void setDefaultValuesEmployee() {
        this.setRatePerHour(100);
        this.setPosition("Admin");
    }

}
