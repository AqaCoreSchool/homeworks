package com.corevalue.oop.task.models.salads;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Chicken_Garden_Salad extends Dish {
    private final static String name = "Chicken Garden Salad";
    private final static double price = 1.99;
    private final static int calories = 520;
    public Chicken_Garden_Salad(Category category) {
        super(price, name, category, calories);
    }
}
