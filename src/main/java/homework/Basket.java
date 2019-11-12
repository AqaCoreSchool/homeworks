package homework;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Product> order = new ArrayList<Product>();

    public void showOrder(List<Product> order) {

        float totalPrice = 0;

        for (int i = 0; i < order.size(); i++) {
            System.out.println("Product number: " + i + ". \"" + order.get(i).getProductName() + "\"  Price : " + order.get(i).getPrice() + "$");
            totalPrice += (float) order.get(i).getPrice();
        }
        System.out.println("Total price: " + totalPrice + "$");
    }
}
