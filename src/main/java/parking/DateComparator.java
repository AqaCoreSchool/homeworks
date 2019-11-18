package parking;

import java.util.Comparator;

public class DateComparator implements Comparator<AbstractVehicle> {
    @Override
    public int compare(AbstractVehicle v1, AbstractVehicle v2) {
        return v1.getDateIn().compareTo(v2.getDateOut());
    }

}