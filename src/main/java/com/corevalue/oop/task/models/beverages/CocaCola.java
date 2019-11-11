package com.corevalue.oop.task.models.beverages;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class CocaCola extends Dish {
    private final static String name = "Coca-Cola";
    private final static double price = 1.59;
    private final static int calories = 140;
    public CocaCola(Category category) {
        super(price, name, category, calories);
    }
}
