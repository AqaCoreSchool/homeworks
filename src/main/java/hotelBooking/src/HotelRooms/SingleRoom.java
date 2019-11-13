package HotelRooms;

public class SingleRoom extends Hotel{

    private int singleCost;
    private int numberOfPeople;

    public SingleRoom(int r, int numberOfPeople) {
        super(r);
        singleCost = r;
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getSingleCost() {
        return singleCost;
    }
}

