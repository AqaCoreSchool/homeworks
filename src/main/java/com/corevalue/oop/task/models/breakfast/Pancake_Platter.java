package com.corevalue.oop.task.models.breakfast;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Pancake_Platter extends Dish {
    private final static String name = "Pancake Platter";
    private final static double price = 3.69;
    private final static int calories = 440;
    public Pancake_Platter(Category category) {
        super(price, name, category, calories);
    }
}
