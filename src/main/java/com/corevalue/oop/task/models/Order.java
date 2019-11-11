package com.corevalue.oop.task.models;

import java.util.Map;
import java.util.TreeMap;

public class Order {
    private double price;
    private Map<Dish, Integer> dishes = new TreeMap<>();

    public double getPrice() {
        return price;
    }

    public Order addDishes(Dish dish, int quantity) {
        dishes.put(dish, quantity);
        double dishPrice = dish.getPrice() * quantity;
        price += dishPrice;
        return this;
    }

    public Order removeDish(Dish dish, int quantity){
        Integer temp = dishes.get(dish);
        System.out.println(dishes);
        Integer remove = temp - quantity;
        dishes.put(dish, remove);
        return this;
    }

    public Order priceWithDiscount(double percentages){
        price = price - (price * percentages /100);
        return this;
    }

    @Override
    public String toString() {
        return "The order consist of " + dishes.size() + " kind of dishes: \n" + dishes + " \nand costs " + price + " $";
    }
}
