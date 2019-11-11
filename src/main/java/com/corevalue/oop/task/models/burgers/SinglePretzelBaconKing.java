package com.corevalue.oop.task.models.burgers;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class SinglePretzelBaconKing extends Dish {
    private final static String name = "Single Pretzel Bacon King";
    private final static double price = 4.59;
    private final static int calories = 920;
    public SinglePretzelBaconKing(Category category) {
        super(price, name, category, calories);
    }
}
