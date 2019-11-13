package Сustomers;

public class Pensioner extends Person implements Human {

    public Pensioner(int age, int pay)
    {
        super(age,pay);
    }

    public void getHuman() {
        System.out.println(this.pay);
    }

}
