package com.corevalue.oop.task.models;

import com.corevalue.oop.task.enums.Category;

public class Dish implements Comparable<Dish> {
    private final double price;
    private final String name;
    private final Category category;
    private final int calories;

    public Dish(double price, String name, Category category, int calories) {
        if (price < 0) {
            throw new IllegalArgumentException("Price can not be less then zero.");
        }
        this.price = price;

        if (price < 0) {
            throw new IllegalArgumentException("Calories can not be less then zero.");
        }
        this.calories = calories;

        if (name == null) {
            throw new NullPointerException("Argument name can not be null.");
        }
        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Name of dishes can not be empty.");
        }
        this.name = name;

        if (category == null) {
            throw new NullPointerException("Argument category can not be null.");
        }
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getCalories() { return calories; }

    @Override
    public String toString() {
        return '['+ "Price = " + " " + price +
                ", name = '" + name + '\'' +
                ", category = " + category +
                ", calories = " + calories + ']' + " number of dishes ";
    }

    @Override
    public int compareTo(Dish o) {
        if (price == o.price){
            return 0;
        }else if(price > o.price){
            return 1;
        }else {
            return -1;
        }
    }
}
