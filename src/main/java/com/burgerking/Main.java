package com.burgerking;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu daymenu = new Menu("Everyday many");
        daymenu.addProduct(new Food("Cheeseburger", FoodType.BURGER, 350, 77.00, "regular"));
        daymenu.addProduct(new Food("Big Mac", FoodType.BURGER, 550, 110.00, "big"));;
        daymenu.addProduct(new Food("Fries", FoodType.FRIED, 400, 70.00, "small"));
        daymenu.addProduct(new Food("Hamburger", FoodType.BURGER, 320, 56.00, "regular"));
        daymenu.addProduct(new Food("Americano", FoodType.COFFEE, 80, 29.00, "medium"));
        daymenu.addProduct(new Food("Fries&cheese", FoodType.FRIED, 600, 100.45, "big"));
        daymenu.addProduct(new Food("Espresso", FoodType.COFFEE, 65, 25.00, "small"));
        daymenu.addProduct(new Food("Bacon burger", FoodType.BURGER, 395, 99.99, "regular"));
        daymenu.addProduct(new Food("Chicken wings", FoodType.FRIED, 420, 87.70, "small"));
        daymenu.addProduct(new Food("Chips", FoodType.FRIED, 120, 45.00, "medium"));
        daymenu.addProduct(new Food("Double Burger", FoodType.BURGER, 545, 112.00, "big"));
        daymenu.addProduct(new Food("Marshmallow Latte", FoodType.COFFEE, 123, 56.00, "big"));
        daymenu.addProduct(new Food("Cola", FoodType.BEVERAGE, 57, 29.55, "small"));
        daymenu.addProduct(new Food("Cola", FoodType.BEVERAGE, 78, 49.99, "big"));
        System.out.println("1. Show available dishes(#no, category, name, price, calories, size):");
        daymenu.display(daymenu.getProductList());

        System.out.println("2. Show dishes filtered by category:");
        /*set food category here:
        0 - Burgers, 1 - Beverages, 2 - Coffee, 3 - Fried food*/
        int filtertype = 1;
        System.out.println("Type selected: " + FoodType.values()[filtertype].name());
        daymenu.filter(filtertype);
        daymenu.display(daymenu.getFilteredList());

        System.out.println("3. Show available dishes sorted by price:");
        daymenu.sortByPrice();
        daymenu.display(daymenu.getProductList());

        System.out.println("4. Search items by criteria:");

        /*There is 3 methods:
        checkOneOf(param) - to check if at least one item from menu list matches
        checkAll(param) - to check if all items from menu list matches
        checkNone(param) - to check if none items from menu list matches

        overloaded for 3 food parameters depends on input method parameter type
        param type Double - for the price (NEGATIVE - below price, POSITIVE - above price)
        param type Integer - for the calories (NEGATIVE - below calories value, POSITIVE - above calories value)
        param type String - for the size (equals or no)
         */
        System.out.println("1) is one of");
        Double priceValue = -30.00;
        Boolean result = daymenu.checkOneOf(priceValue);
        System.out.format("At least one of all food items price is < %3.2f : %b \n", Math.abs(priceValue), result);

        System.out.println("2) is all");
        Integer caloriesValue = 65;
        result = daymenu.checkAll(caloriesValue);
        System.out.format("All food items calories is > %3d : %b\n",  caloriesValue, result);

        System.out.println("3) is none");
        String sizeValue = "biggest";
        result = daymenu.checkNone(sizeValue);
        System.out.format("None of food items size is '%s' : %b\n", sizeValue, result);

        System.out.println("5. Get pair Name - Price of lowest item prices from every category, sorted by name:");
        List<Food> lowestNamePricePerType = daymenu.getLowestPriceByType();
        printNamePrice(lowestNamePricePerType);

    }

    public static void printNamePrice(List<Food> list){
        for(Food food: list) {
            System.out.format("%s - %3.2f $, ", food.getName(), food.getPrice());
        }
        System.out.println("");
    }
}
