package parking;

import java.util.Comparator;

public class NumberComparator implements Comparator<AbstractVehicle> {
    @Override
    public int compare(AbstractVehicle v1, AbstractVehicle v2) {
        return v1.getNumber().compareTo(v2.getNumber());
    }
}
