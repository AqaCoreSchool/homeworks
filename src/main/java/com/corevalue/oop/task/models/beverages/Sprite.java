package com.corevalue.oop.task.models.beverages;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Sprite extends Dish {
    private final static String name = "Sprite";
    private final static int calories = 140;
    private final static double price = 1.59;
    public Sprite(Category category) {
        super(price, name, category, calories);
    }
}
