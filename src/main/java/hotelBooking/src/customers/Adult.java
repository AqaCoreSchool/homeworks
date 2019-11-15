package customers;

public class Adult extends Person implements Human {

    public Adult(int age, int pay) {
        super(age, pay);
    }

    public void doHuman() {
        System.out.println(this.pay);
    }

}
