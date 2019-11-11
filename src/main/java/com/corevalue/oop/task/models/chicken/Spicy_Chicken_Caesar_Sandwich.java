package com.corevalue.oop.task.models.chicken;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Spicy_Chicken_Caesar_Sandwich extends Dish {
    private final static String name = "Spicy Chicken Caesar Sandwich";
    private final static double price = 5.19;
    private final static int calories = 830;
    public Spicy_Chicken_Caesar_Sandwich(Category category) {
        super(price, name, category, calories);
    }
}
