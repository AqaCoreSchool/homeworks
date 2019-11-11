package com.corevalue.oop.task.models.beverages;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class DrPepper extends Dish {
    private final static String name = "DrPepper";
    private final static double price = 1.59;
    private final static int calories = 140;
    public DrPepper(Category category) {
        super(price, name, category, calories);
    }
}
