package ParkingLot;

public class SecurityStaff extends AbstractEmployee {

    public SecurityStaff() {
        standard();
    }

    public SecurityStaff(String name, int workHours) {
        super(name, workHours);
        standard();
    }

    @Override
    public void standard() {
        this.setPosition("Security");
        this.setRatePerHour(40);
    }
}
