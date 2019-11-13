package HotelRooms;

public class VipRoom extends Hotel {

    private int numberOfPeople;

    public VipRoom(int r, int numberOfPeople) {
        super(r);
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
