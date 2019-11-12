package com.burgerking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Menu {
    private String name;
    private List<Food> productList;
    private List<Food> filteredList;

    public Menu(String name) {
        this.name = name;
        this.productList = new ArrayList<>();
        this.filteredList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getProductList() {
        return productList;
    }

    public void setProductList(List<Food> productList) {
        this.productList = productList;
    }

    public List<Food> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<Food> filteredList) {
        this.filteredList = filteredList;
    }

    public void addProduct(Food food){
        this.productList.add(food);
    }

    public void removeProduct(Food food){
        this.productList.remove(food);
    }

    Comparator<Food> compareByPrice = new Comparator<Food>() {
        @Override
        public int compare(Food f1, Food f2) {
            return f1.getPrice().compareTo(f2.getPrice());
        }
    };

    Comparator<Food> compareByName = new Comparator<Food>() {
        @Override
        public int compare(Food f1, Food f2) {
            return f1.getName().compareTo(f2.getName());
        }
    };

    public void sortByPrice(){
        this.productList.sort(compareByPrice);
    }

    public void sortByName(){
        this.productList.sort(compareByName);
    }

    public void display(List<Food> list){
        int printIdCounter = 0;
        for(Food food: list){
            printIdCounter++;
            System.out.format("%3s %8s %18s %7.2f$ %5d Cal. %8s",
                    printIdCounter, food.getTypeName(), food.getName(), food.getPrice(), food.getCalories(), food.getSize());
            System.out.println();
        }
        System.out.println();
    }

    public void filter(int filterOption) {
        List<Food> filtered = new ArrayList<>();
        for(Food food: this.getProductList()){
            if(food.getType().ordinal()==filterOption){
                filtered.add(food);
            }
        }
        this.setFilteredList(filtered);
    }

    public Boolean checkOneOf(Double price){
        if(price>0){
            for(Food food: this.getProductList()){
                if(food.getPrice()>=price){
                    return true;
                }
            }
        } else if (price<0) {
            for(Food food: this.getProductList()){
                if(food.getPrice()<=Math.abs(price)){
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkOneOf(Integer calories){
        if(calories>0){
            for(Food food: this.getProductList()){
                if(food.getCalories()>=calories){
                    return true;
                }
            }
        } else if (calories<0) {
            for(Food food: this.getProductList()){
                if(food.getCalories()<=Math.abs(calories)){
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkOneOf(String size){
        for(Food food: this.getProductList()){
            if(food.getSize().equalsIgnoreCase(size)){
                return true;
            }
        }
        return false;
    }

    public Boolean checkAll(Double price){
        if(price>0){
            for(Food food: this.getProductList()){
                if(food.getPrice()<=price){
                    return false;
                }
            }
        } else if (price<0) {
            for(Food food: this.getProductList()){
                if(food.getPrice()>=Math.abs(price)){
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean checkAll(Integer calories){
        if(calories>0){
            for(Food food: this.getProductList()){
                if(food.getCalories()<=calories){
                    return false;
                }
            }
        } else if (calories<0) {
            for(Food food: this.getProductList()){
                if(food.getCalories()>=Math.abs(calories)){
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean checkAll(String size){
        for(Food food: this.getProductList()){
            if(!food.getSize().equalsIgnoreCase(size)){
                return false;
            }
        }
        return true;
    }

    public Boolean checkNone(Double price){
        if(price>0){
            for(Food food: this.getProductList()){
                if(food.getPrice()>=price){
                    return false;
                }
            }
        } else if (price<0) {
            for(Food food: this.getProductList()){
                if(food.getPrice()<=Math.abs(price)){
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean checkNone(Integer calories){
        if(calories>0){
            for(Food food: this.getProductList()){
                if(food.getCalories()>=calories){
                    return false;
                }
            }
        } else if (calories<0) {
            for(Food food: this.getProductList()){
                if(food.getCalories()<=Math.abs(calories)){
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean checkNone(String size){
        for(Food food: this.getProductList()){
            if(food.getSize().equalsIgnoreCase(size)){
                return false;
            }
        }
        return true;
    }

    public List<Food> getLowestPriceByType(){
        List<Food> typesList = new ArrayList<>();
        List<Food> returnList = new ArrayList<>();
        for(int i=0;i<FoodType.values().length;i++){
            for(Food food: this.getProductList()) {
                if (food.getType().ordinal() == i) {
                    typesList.add(food);
                }
            }
            if (typesList.size()>0) {
                typesList.sort(compareByPrice);
                returnList.add(typesList.get(0));
            }
            typesList.clear();
        }
        returnList.sort(compareByName);
        return returnList;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }
}
