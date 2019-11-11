package com.corevalue.oop.task.models.chicken;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class CrispyTaco extends Dish {
    private final static String name = "Crispy Taco";
    private final static double price = 2.29;
    private final static int calories = 170;
    public CrispyTaco(Category category) {
        super(price, name, category, calories);
    }
}
