package hotelRooms;

public class TypesHotelRooms {

    private String category;
    private int cost;
    private int capacity;
    private int numberOfRooms;
    private int area;
    boolean presence;

    public TypesHotelRooms(String category, int cost, int capacity, int numberOfRooms, int area, boolean presence) {
        this.category = category;
        this.cost = cost;
        this.capacity = capacity;
        this.numberOfRooms = numberOfRooms;
        this.area = area;
        this.presence = presence;
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