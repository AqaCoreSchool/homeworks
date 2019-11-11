package com.corevalue.oop.task.models.chicken;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Original_Chicken extends Dish {
    private final static String name = "Original Chicken";
    private final static double price = 4.09;
    private final static int calories = 660;
    public Original_Chicken(Category category) {
        super(price, name, category, calories);
    }
}
