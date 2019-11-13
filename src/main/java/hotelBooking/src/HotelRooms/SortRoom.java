package HotelRooms;

import java.util.Comparator;

public class SortRoom implements Comparator<SortRoom> {

    int cost;
    int numberOfPeople;

    public SortRoom(int cost, int numberOfPeople) {
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Rooms{");
        sb.append("cost=").append(cost);
        sb.append(", room=").append(numberOfPeople);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compare(SortRoom costRoom, SortRoom quantity) {
        if (this.cost < costRoom.cost && this.numberOfPeople < quantity.numberOfPeople) {
            return 0;
        }else {
            return -1;
        }
    }
}