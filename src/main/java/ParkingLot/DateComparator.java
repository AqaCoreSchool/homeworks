package ParkingLot;

import java.util.Comparator;

public class DateComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v1.getDateIn().compareTo(v2.getDateOut());
    }
}