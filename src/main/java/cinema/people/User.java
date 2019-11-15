package cinema.people;

import cinema.Searchable;

public class User extends Human implements Searchable {

    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    //This is override of "toString" method... he-he)) It's a joke)
    @Override
    public String toString() {
        return "User{" +
                "discount=" + discount +
                '}';
    }
}
