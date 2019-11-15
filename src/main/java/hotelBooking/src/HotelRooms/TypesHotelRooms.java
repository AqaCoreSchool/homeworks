package hotelRooms;

public class TypesHotelRooms {

    protected String category;
    protected int cost;
    protected int capacity;
    protected int numberOfRooms;
    protected int area;

    public TypesHotelRooms(String category, int cost, int capacity, int numberOfRooms, int area) {
        this.category = category;
        this.cost = cost;
        this.capacity = capacity;
        this.numberOfRooms = numberOfRooms;
        this.area = area;
    }

    public String getCategory() { return category; }

    public int getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getArea() {
        return area;
    }

}