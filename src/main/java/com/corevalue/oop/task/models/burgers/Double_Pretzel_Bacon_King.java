package com.corevalue.oop.task.models.burgers;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Double_Pretzel_Bacon_King extends Dish {
    private final static String name = "Double Pretzel Bacon King";
    private final static double price = 5.29;
    private final static int calories = 1240;
    public Double_Pretzel_Bacon_King(Category category) {
        super(price, name, category, calories);
    }
}
