package com.corevalue.oop.task;

import com.corevalue.oop.task.enums.Category;
import com.corevalue.oop.task.models.Order;
import com.corevalue.oop.task.models.beverages.CocaCola;
import com.corevalue.oop.task.models.beverages.DrPepper;
import com.corevalue.oop.task.models.beverages.Sprite;
import com.corevalue.oop.task.models.breakfast.Fully_Loaded_Biscuit;
import com.corevalue.oop.task.models.breakfast.Pancake_Platter;
import com.corevalue.oop.task.models.burgers.*;
import com.corevalue.oop.task.models.chicken.Chicken_Nuggets;
import com.corevalue.oop.task.models.chicken.Crispy_Taco;
import com.corevalue.oop.task.models.chicken.Original_Chicken;
import com.corevalue.oop.task.models.chicken.Spicy_Chicken_Caesar_Sandwich;
import com.corevalue.oop.task.models.coffee.Cafe_Caramel_Frappe;
import com.corevalue.oop.task.models.coffee.Cafe_Coffee;
import com.corevalue.oop.task.models.salads.Chicken_Club_Salad;
import com.corevalue.oop.task.models.salads.Chicken_Garden_Salad;
import com.corevalue.oop.task.models.salads.Garden_Side_Salad;

public class Demo {
    public static void main(String[] args) {
        CocaCola cocaCola = new CocaCola(Category.Beverages);
        DrPepper drPepper = new DrPepper(Category.Beverages);
        Sprite sprite = new Sprite(Category.Beverages);

        Fully_Loaded_Biscuit fully_loaded_biscuit = new Fully_Loaded_Biscuit(Category.Breakfast);
        Pancake_Platter pancake_platter = new Pancake_Platter(Category.Breakfast);

        Bacon_Cheeseburger bacon_cheeseburger = new Bacon_Cheeseburger(Category.Burgers);
        Double_Pretzel_Bacon_King double_pretzel_bacon_king = new Double_Pretzel_Bacon_King(Category.Burgers);
        Hamburger hamburger = new Hamburger(Category.Burgers);
        Single_Pretzel_Bacon_King single_pretzel_bacon_king = new Single_Pretzel_Bacon_King(Category.Burgers);
        Triple_Stacker_King triple_stacker_king = new Triple_Stacker_King(Category.Burgers);

        Chicken_Nuggets chicken_nuggets = new Chicken_Nuggets(Category.Chicken_and_More);
        Crispy_Taco crispy_taco = new Crispy_Taco(Category.Chicken_and_More);
        Original_Chicken original_chicken = new Original_Chicken(Category.Chicken_and_More);
        Spicy_Chicken_Caesar_Sandwich spicy_chicken_caesar_sandwich = new Spicy_Chicken_Caesar_Sandwich(Category.Chicken_and_More);

        Cafe_Caramel_Frappe cafe_caramel_frappe = new Cafe_Caramel_Frappe(Category.Coffee);
        Cafe_Coffee cafe_coffee = new Cafe_Coffee(Category.Coffee);

        Chicken_Club_Salad chicken_club_salad = new Chicken_Club_Salad(Category.Salads_and_Veggies);
        Chicken_Garden_Salad chicken_garden_salad = new Chicken_Garden_Salad(Category.Salads_and_Veggies);
        Garden_Side_Salad garden_side_salad = new Garden_Side_Salad(Category.Salads_and_Veggies);

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
