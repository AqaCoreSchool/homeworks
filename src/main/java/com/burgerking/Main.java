package com.burgerking;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu daymenu = new Menu("Everyday many");
        daymenu.addProduct(new Food("Cheeseburger", FoodType.BURGER, 350, 77.00, "regular"));
        daymenu.addProduct(new Food("Big Mac", FoodType.BURGER, 550, 110.00, "big"));;
        daymenu.addProduct(new Food("Fries", FoodType.FRIED, 400, 70.00, "small"));
        daymenu.addProduct(new Food("Hamburger", FoodType.BURGER, 320, 58.01, "regular"));
        daymenu.addProduct(new Food("Americano", FoodType.COFFEE, 80, 29.00, "medium"));
        daymenu.addProduct(new Food("Fries&cheese", FoodType.FRIED, 600, 44.49, "big"));
        daymenu.addProduct(new Food("Espresso", FoodType.COFFEE, 65, 25.00, "small"));
        daymenu.addProduct(new Food("Bacon burger", FoodType.BURGER, 395, 99.99, "regular"));
        daymenu.addProduct(new Food("Chicken wings", FoodType.FRIED, 420, 87.70, "small"));
        daymenu.addProduct(new Food("Chips", FoodType.FRIED, 120, 45.00, "regular"));
        daymenu.addProduct(new Food("Double Burger", FoodType.BURGER, 545, 112.00, "big"));
        daymenu.addProduct(new Food("Marshmallow Latte", FoodType.COFFEE, 123, 56.00, "big"));
        daymenu.addProduct(new Food("Cola", FoodType.BEVERAGE, 57, 16.90, "regular"));
        daymenu.addProduct(new Food("Double Cola", FoodType.BEVERAGE, 78, 49.99, "big"));
        daymenu.addProduct(new Food("Water", FoodType.BEVERAGE, 12, 23.99, "regular"));
        daymenu.addProduct(new Food("Chickenburger", FoodType.BURGER, 99, 67.87, "regular"));
        boolean flow = true;
        while(flow) {
            System.out.println("Input option:");
            System.out.println("1 - show available dishes(menu), 2 - filter dish by type, " +
                    "3 - sort dishes by price, 4 - is any food price bigger then, \n" +
                    "5 - check is all food calories lower then, 6 - check is none food size equals to, " +
                    "7 - cheapest item Name-Price per type, 8 - show map [FoodType : items amount], " +
                    "0 - exit");
            String option = scanner.next();
            switch(option){
                case "1":{
                    daymenu.showMenu(daymenu.getProductList());
                    break;
                }
                case "2":{
                    System.out.println("Input type: " +
                            "0 - burgers, 1 - beverages, 2 - coffee, 3 - fried food, 4 - salads");
                    int filterOption = scanner.nextInt();
                    daymenu.filterMenuByFoodType(filterOption);
                    daymenu.showMenu(daymenu.getFilteredList());
                    break;
                }
                case "3":{
                    daymenu.sortByPrice();
                    daymenu.showMenu(daymenu.getProductList());
                    break;
                }
                case "4":{
                    System.out.println("Check if at least one food item price is bigger than criteria");
                    System.out.println("Input double price criteria:");
                    double priceCriteria = scanner.nextDouble();
                    System.out.format("Result: %b\n", daymenu.isAnyFoodPriceBiggerThan(priceCriteria));
                    System.out.println();
                    break;
                }
                case "5":{
                    System.out.println("Check if all food items calories are lower than criteria");
                    System.out.println("Input int calories criteria:");
                    int caloriesCriteria = scanner.nextInt();
                    System.out.format("Result: %b\n", daymenu.isAllFoodCaloriesLowerThen(caloriesCriteria));
                    System.out.println();
                    break;
                }
                case "6":{
                    System.out.println("Check if none food items size equals to criteria");
                    System.out.println("Input string size criteria:");
                    String sizeCriteria = scanner.next();
                    System.out.format("Result: %b\n", daymenu.isNoneFoodSizeEqualsTo(sizeCriteria));
                    System.out.println();
                    break;
                }
                case "7":{
                    System.out.println("Pairs Name - Price of lowest item prices from every type, sorted by name:");
                    printNamePrice(daymenu.getLowestPriceByType());
                    break;
                }
                case "8":{
                    System.out.println("Example map [FoodType = Amount of items in menu]");
                    daymenu.fillAmountTypeMap();
                    System.out.println(daymenu.getAmountTypeMap().entrySet());
                    break;
                }
                default:
                    flow = false;
                    scanner.close();
                    break;
            }
        }
    }

    public static void printNamePrice(List<Food> list){
        StringBuffer namePrice = new StringBuffer();
        for(Food food: list) {
            namePrice.append(String.format("%s - %3.2f$, ", food.getName(), food.getPrice()));
        }
        System.out.println(namePrice.deleteCharAt(namePrice.length()-2));
    }
}
