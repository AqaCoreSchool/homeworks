package com.corevalue.oop.task.models.burgers;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Hamburger extends Dish {
    private final static String name = "Hamburger";
    private final static double price = 1;
    private final static int calories = 240;
    public Hamburger(Category category) {
        super(price, name, category, calories);
    }
}
