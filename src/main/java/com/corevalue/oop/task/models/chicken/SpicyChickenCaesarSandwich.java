package com.corevalue.oop.task.models.chicken;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class SpicyChickenCaesarSandwich extends Dish {
    private final static String name = "Spicy Chicken Caesar Sandwich";
    private final static double price = 5.19;
    private final static int calories = 830;
    public SpicyChickenCaesarSandwich(Category category) {
        super(price, name, category, calories);
    }
}
