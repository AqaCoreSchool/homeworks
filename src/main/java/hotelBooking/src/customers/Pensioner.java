package customers;

public class Pensioner extends Person implements Human {

    public Pensioner(int age, int pay)
    {
        super(age,pay);
    }

    public void doHuman() {
        System.out.println(this.pay);
    }

}
