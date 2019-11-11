package com.corevalue.oop.task.models.salads;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class GardenSideSalad extends Dish {
    private final static String name = "Garden Side Salad";
    private final static double price = 6.19;
    private final static int calories = 60;
    public GardenSideSalad(Category category) {
        super(price, name, category, calories);
    }
}
