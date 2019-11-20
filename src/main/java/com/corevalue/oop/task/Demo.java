package com.corevalue.oop.task;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Dish;
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
        CocaCola cocaCola = new CocaCola(Category.BEVERAGES);
        DrPepper drPepper = new DrPepper(Category.BEVERAGES);
        Sprite sprite = new Sprite(Category.BEVERAGES);

        FullyLoadedBiscuit fully_loaded_biscuit = new FullyLoadedBiscuit(Category.BREAKFAST);
        PancakePlatter pancake_platter = new PancakePlatter(Category.BREAKFAST);

        BaconCheeseburger bacon_cheeseburger = new BaconCheeseburger(Category.BURGERS);
        DoublePretzelBaconKing double_pretzel_bacon_king = new DoublePretzelBaconKing(Category.BURGERS);
        Hamburger hamburger = new Hamburger(Category.BURGERS);
        SinglePretzelBaconKing single_pretzel_bacon_king = new SinglePretzelBaconKing(Category.BURGERS);
        TripleStackerKing triple_stacker_king = new TripleStackerKing(Category.BURGERS);

        ChickenNuggets chicken_nuggets = new ChickenNuggets(Category.CHICKEN_AND_MORE);
        CrispyTaco crispy_taco = new CrispyTaco(Category.CHICKEN_AND_MORE);
        OriginalChicken original_chicken = new OriginalChicken(Category.CHICKEN_AND_MORE);
        SpicyChickenCaesarSandwich spicy_chicken_caesar_sandwich = new SpicyChickenCaesarSandwich(Category.CHICKEN_AND_MORE);

        CafeCaramelFrappe cafe_caramel_frappe = new CafeCaramelFrappe(Category.COFFEE);
        CafeCoffee cafe_coffee = new CafeCoffee(Category.COFFEE);

        ChickenClubSalad chicken_club_salad = new ChickenClubSalad(Category.SALADS_AND_VEGGIES);
        ChickenGardenSalad chicken_garden_salad = new ChickenGardenSalad(Category.SALADS_AND_VEGGIES);
        GardenSideSalad garden_side_salad = new GardenSideSalad(Category.SALADS_AND_VEGGIES);

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
