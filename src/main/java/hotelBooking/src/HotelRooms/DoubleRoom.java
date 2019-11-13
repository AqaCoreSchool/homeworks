package HotelRooms;

public class DoubleRoom extends Hotel {

    private int numberOfPeople;

    public DoubleRoom(int r, int numberOfPeople) {
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
