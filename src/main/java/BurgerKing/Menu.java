package BurgerKing;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private List<Food> productList;

    public Menu(String name) {
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getProductList() {
        return productList;
    }

    public void setProductList(List<Food> productList) {
        this.productList = productList;
    }

    public void addProduct(Food food){
//        to be done...
    }

    public void removeProduct(Food food){
//        to be done...
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }
}
