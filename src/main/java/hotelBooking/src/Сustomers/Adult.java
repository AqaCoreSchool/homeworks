package Сustomers;

public class Adult extends Person implements Human {

    public Adult(int age, int pay) {
        super(age,pay);
    }

    public void getHuman() {
        System.out.println(this.pay);
    }

}
