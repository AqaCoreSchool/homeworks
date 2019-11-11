package com.corevalue.oop.task.models.chicken;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Chicken_Nuggets extends Dish {
    private final static String name = "Chicken Nuggets";
    private final static double price = 5.99;
    private final static int calories = 170;
    public Chicken_Nuggets(Category category) {
        super(price, name, category, calories);
    }
}
