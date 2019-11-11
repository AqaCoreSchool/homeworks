package com.corevalue.oop.task.models.coffee;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;

public class Cafe_Caramel_Frappe extends Dish {
    private final static String name = "Café Caramel Frappe";
    private final static double price = 3.09;
    private final static int calories = 500;
    public Cafe_Caramel_Frappe(Category category) {
        super(price, name, category, calories);
    }
}
