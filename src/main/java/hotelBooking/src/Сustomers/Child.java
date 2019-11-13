package Сustomers;

public class Child extends Person implements Human {


    public Child(int age, int pay) {
        super(age, pay);
    }

    public void getHuman(){
        System.out.println(this.pay/2);
    }
}
