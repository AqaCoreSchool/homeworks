package com.corevalue.oop.task.models.burgers;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Bacon_Cheeseburger extends Dish {
    private final static String name = "Bacon Cheeseburger";
    private final static double price = 6.29;
    private final static int calories = 320;
    public Bacon_Cheeseburger(Category category) {
        super(price, name, category, calories);
    }
}
