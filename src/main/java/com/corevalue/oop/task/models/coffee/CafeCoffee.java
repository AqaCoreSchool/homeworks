package com.corevalue.oop.task.models.coffee;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class CafeCoffee extends Dish {
    private final static String name = "Café Coffee";
    private final static double price = 1.59;
    private final static int calories = 0;
    public CafeCoffee(Category category) {
        super(price, name, category, calories);
    }
}
