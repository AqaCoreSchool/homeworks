package com.corevalue.oop.task.models.chicken;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class ChickenNuggets extends Dish {
    private final static String name = "Chicken Nuggets";
    private final static double price = 5.99;
    private final static int calories = 170;
    public ChickenNuggets(Category category) {
        super(price, name, category, calories);
    }
}
