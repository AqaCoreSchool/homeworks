public class Adult extends Person implements Human{

    protected Adult(int age, int pay) {
        super(age,pay);
    }

    public void human() {
        System.out.println(this.pay);
    }

}
