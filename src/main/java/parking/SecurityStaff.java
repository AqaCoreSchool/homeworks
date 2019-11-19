package parking;

public class SecurityStaff extends AbstractEmployee {

    public SecurityStaff() {
        setDefaultValuesEmployee();
    }

    public SecurityStaff(String name, int workHours) {
        super(name, workHours);
        setDefaultValuesEmployee();
    }

    @Override
    public void setDefaultValuesEmployee() {
        this.setPosition("Security");
        this.setRatePerHour(40);
    }
}
