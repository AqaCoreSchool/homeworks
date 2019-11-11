package com.corevalue.oop.task;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Order;
import com.corevalue.oop.task.models.beverages.CocaCola;
import com.corevalue.oop.task.models.beverages.DrPepper;
import com.corevalue.oop.task.models.beverages.Sprite;
import com.corevalue.oop.task.models.breakfast.FullyLoadedBiscuit;
import com.corevalue.oop.task.models.breakfast.PancakePlatter;
import com.corevalue.oop.task.models.burgers.*;
import com.corevalue.oop.task.models.chicken.ChickenNuggets;
import com.corevalue.oop.task.models.chicken.CrispyTaco;
import com.corevalue.oop.task.models.chicken.OriginalChicken;
import com.corevalue.oop.task.models.chicken.SpicyChickenCaesarSandwich;
import com.corevalue.oop.task.models.coffee.CafeCaramelFrappe;
import com.corevalue.oop.task.models.coffee.CafeCoffee;
import com.corevalue.oop.task.models.salads.ChickenClubSalad;
import com.corevalue.oop.task.models.salads.ChickenGardenSalad;
import com.corevalue.oop.task.models.salads.GardenSideSalad;

public class Demo {
    public static void main(String[] args) {
        CocaCola cocaCola = new CocaCola(Category.Beverages);
        DrPepper drPepper = new DrPepper(Category.Beverages);
        Sprite sprite = new Sprite(Category.Beverages);

        FullyLoadedBiscuit fully_loaded_biscuit = new FullyLoadedBiscuit(Category.Breakfast);
        PancakePlatter pancake_platter = new PancakePlatter(Category.Breakfast);

        BaconCheeseburger bacon_cheeseburger = new BaconCheeseburger(Category.Burgers);
        DoublePretzelBaconKing double_pretzel_bacon_king = new DoublePretzelBaconKing(Category.Burgers);
        Hamburger hamburger = new Hamburger(Category.Burgers);
        SinglePretzelBaconKing single_pretzel_bacon_king = new SinglePretzelBaconKing(Category.Burgers);
        TripleStackerKing triple_stacker_king = new TripleStackerKing(Category.Burgers);

        ChickenNuggets chicken_nuggets = new ChickenNuggets(Category.Chicken_and_More);
        CrispyTaco crispy_taco = new CrispyTaco(Category.Chicken_and_More);
        OriginalChicken original_chicken = new OriginalChicken(Category.Chicken_and_More);
        SpicyChickenCaesarSandwich spicy_chicken_caesar_sandwich = new SpicyChickenCaesarSandwich(Category.Chicken_and_More);

        CafeCaramelFrappe cafe_caramel_frappe = new CafeCaramelFrappe(Category.Coffee);
        CafeCoffee cafe_coffee = new CafeCoffee(Category.Coffee);

        ChickenClubSalad chicken_club_salad = new ChickenClubSalad(Category.Salads_and_Veggies);
        ChickenGardenSalad chicken_garden_salad = new ChickenGardenSalad(Category.Salads_and_Veggies);
        GardenSideSalad garden_side_salad = new GardenSideSalad(Category.Salads_and_Veggies);

        Order order = new Order();

        order.addDishes(cocaCola, 1);
        order.addDishes(double_pretzel_bacon_king, 2);
        order.addDishes(triple_stacker_king, 1);
        order.addDishes(chicken_nuggets, 3);
        order.addDishes(chicken_club_salad, 1);

        order.priceWithDiscount(10);


        System.out.println(order.toString());
    }
}
