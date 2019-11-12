public class SingleRoom extends Hotel implements PricePerRoom{


    public SingleRoom(int r) {
        super(r);
    }

    public void getPriceRoom() {
        System.out.println("price per single room: " + r);
    }

}

