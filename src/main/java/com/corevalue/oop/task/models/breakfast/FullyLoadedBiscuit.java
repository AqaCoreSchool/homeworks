package com.corevalue.oop.task.models.breakfast;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class FullyLoadedBiscuit extends Dish {
    private final static String name = "Fully Loaded Biscuit";
    private final static double price = 1;
    private final static int calories = 610;
    public FullyLoadedBiscuit(Category category) {
        super(price, name, category, calories);
    }
}
