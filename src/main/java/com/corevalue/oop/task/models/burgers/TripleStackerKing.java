package com.corevalue.oop.task.models.burgers;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class TripleStackerKing extends Dish {
    private final static String name = "Triple Stacker King";
    private final static double price = 2.89;
    private final static int calories = 1370;
    public TripleStackerKing(Category category) {
        super(price, name, category, calories);
    }
}
