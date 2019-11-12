public class DoubleRoom extends Hotel implements PricePerRoom{

    public DoubleRoom(int r) {
        super(r);
    }

    public void getPriceRoom() {
        System.out.println("price per double room: " + r);
    }


}
