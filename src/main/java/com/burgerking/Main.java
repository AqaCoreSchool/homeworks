package com.burgerking;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu daymenu = new Menu("Everyday many");
        daymenu.addProduct(new Food("Cheeseburger", FoodType.BURGER, 350, 77.00, "regular"));
        daymenu.addProduct(new Food("Big Mac", FoodType.BURGER, 550, 110.00, "big"));;
        daymenu.addProduct(new Food("Fries", FoodType.FRIED, 400, 70.00, "small"));
        daymenu.addProduct(new Food("Hamburger", FoodType.BURGER, 320, 77.01, "regular"));
        daymenu.addProduct(new Food("Americano", FoodType.COFFEE, 80, 29.00, "medium"));
        daymenu.addProduct(new Food("Fries&cheese", FoodType.FRIED, 600, 44.49, "big"));
        daymenu.addProduct(new Food("Espresso", FoodType.COFFEE, 65, 25.00, "small"));
        daymenu.addProduct(new Food("Bacon burger", FoodType.BURGER, 395, 99.99, "regular"));
        daymenu.addProduct(new Food("Chicken wings", FoodType.FRIED, 420, 87.70, "small"));
        daymenu.addProduct(new Food("Chips", FoodType.FRIED, 120, 45.00, "medium"));
        daymenu.addProduct(new Food("Double Burger", FoodType.BURGER, 545, 112.00, "big"));
        daymenu.addProduct(new Food("Marshmallow Latte", FoodType.COFFEE, 123, 56.00, "big"));
        daymenu.addProduct(new Food("Cola", FoodType.BEVERAGE, 57, 14.77, "small"));
        daymenu.addProduct(new Food("Double Cola", FoodType.BEVERAGE, 78, 49.99, "big"));
        daymenu.addProduct(new Food("Water", FoodType.BEVERAGE, 10, 23.99, "small"));
        System.out.println("1. Show available dishes(#no, category, name, price, calories, size):");
        daymenu.display(daymenu.getProductList());

        System.out.println("2. Show dishes filtered by category:");
        /*set food category here:
        0 - Burgers, 1 - Beverages, 2 - Coffee, 3 - Fried food*/
        int filtertype = 1;
        System.out.println("Type selected: " + FoodType.values()[filtertype].name());
        daymenu.filter(filtertype);
        daymenu.display(daymenu.getFilteredList());

        /* Sorting available by price or by name ASC*/
        System.out.println("3. Show available dishes sorted by price:");
        daymenu.sortByPrice();
        daymenu.display(daymenu.getProductList());

//        System.out.println("\n3. Show available dishes sorted by name:");
//        daymenu.sortByName();
//        daymenu.display(daymenu.getProductList());

        System.out.println("4. Search items by criteria:");

        /*There is 3 methods:
        checkOneOf(param) - to check if at least one item from menu list matches
        checkAll(param) - to check if all items from menu list matches
        checkNone(param) - to check if none items from menu list matches

        overloaded for 3 food parameters depends on input method parameter type
        param type Double - for the price (NEGATIVE - below price, POSITIVE - above price)
        param type Integer - for the calories (NEGATIVE - below calories value, POSITIVE - above calories value)
        param type String - for the size (equals or no)

        to check different methods for different food fields change input parameter
         */
        Double priceValue = 100.43;
        Integer caloriesValue = -601;
        String sizeValue = "bigger";

        System.out.println("\n1) is one of");
        System.out.format("At least one of all prices is > %3.2f : %b \n",
                Math.abs(priceValue),
                daymenu.checkOneOf(priceValue));

        System.out.println("\n2) is all");
        System.out.format("All food items calories is < %3d : %b\n",
                Math.abs(caloriesValue),
                daymenu.checkAll(caloriesValue));

        System.out.println("\n3) is none");
        System.out.format("None of food items size is '%s' : %b\n", sizeValue, daymenu.checkNone(sizeValue));

        System.out.println("\n5. Get pair Name - Price of lowest item prices from every category, sorted by name:");
        printNamePrice(daymenu.getLowestPriceByType());

    }

    public static void printNamePrice(List<Food> list){
        for(Food food: list) {
            System.out.format("%s - %3.2f $, ", food.getName(), food.getPrice());
        }
        System.out.println("");
    }
}
