public class Child extends Person implements Human{


    protected Child(int age, int pay) {
        super(age, pay);
    }

    public void human(){
        System.out.println(this.pay/2);
    }
}
