package homework;

import homework.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class show greeting message to user, list of products and get an order.
 *
 * @author Mykyta Kontsevych
 * @version 1.0 11.11.2019
 */


public class Terminal {

    private List<Product> listOfProducts = new ArrayList<Product>();
    Basket basket = new Basket();

    public Terminal() {
        listOfProducts.add(new Product("Burger", 1.0f));
        listOfProducts.add(new Product("Double Burger", 2.0f));
        listOfProducts.add(new Product("King Burger", 5.0f));
        listOfProducts.add(new Product("Coca Cola", 1.0f));
        listOfProducts.add(new Product("Pepsi", 1.0f));
    }

    public void start() {

        System.out.println("Welcome to \"Burger King\"! \n" +
                "We are glad to see you in our kingdom. \n" +
                "Please, see our menu and select what you want : ");

        showMenu();

        System.out.println("Input a product number:\nFor end ordering enter any letter");

        //List<Product> orderProducts = getOrder();
        basket.showOrder(getOrder());

    }

    private List<Product> getOrder() {
        Scanner in = new Scanner(System.in);

        List<Product> listOfOrders = new ArrayList<Product>();

        while (in.hasNext()) {
            if (in.hasNextInt()) {
                int index = in.nextInt();

                if (indexExists(listOfProducts, index)) {
                    listOfOrders.add(this.listOfProducts.get(index));
                } else {
                    System.out.println("Enter index from the menu.");
                    continue;
                }
                in.next();
            } else {
                break;
            }
        }

        in.close();
        return listOfOrders;
    }

    private void showMenu() {

        for (int i = 0; i < listOfProducts.size(); i++) {
            System.out.println("Product number: " + i + ". \"" + listOfProducts.get(i).getProductName() + "\"  Price : " + listOfProducts.get(i).getPrice() + "$");

        }

    }

    private boolean indexExists(final List list, final int index) {
        return index >= 0 && index < list.size();
    }
}
