package parking;

public class SecurityStaff extends AbstractEmployees {

    SecurityStaff() {
        standard();
    }

    SecurityStaff(String name, int workHours) {
        super(name, workHours);
        standard();
    }

    @Override
    public void standard() {
        this.setPosition("Security");
        this.setRatePerHour(40);
    }

}
