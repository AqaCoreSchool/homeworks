package com.corevalue.oop.task.models.salads;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Chicken_Club_Salad extends Dish {
    private final static String name = "Chicken Club Salad";
    private final static double price = 5.59;
    private final static int calories = 610;
    public Chicken_Club_Salad(Category category) {
        super(price, name, category, calories);
    }
}
