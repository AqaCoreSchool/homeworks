public class SingleRoom extends Hotel implements PricePerRoom{


    public SingleRoom(int r) {
        super(r);
    }

    public void PriceRoom() {
        System.out.println("price per single room: " + r);
    }

}

