package com.burgerking;

import java.util.*;

public class Menu {
    private String name;
    private List<Food> productList;
    private List<Food> filteredList;
    private Map<FoodType, Integer> amountTypeMap;

    public Menu(String name) {
        this.name = name;
        this.productList = new ArrayList<>();
        this.filteredList = new ArrayList<>();
        this.amountTypeMap = new HashMap<>();
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

    public Map<FoodType, Integer> getAmountTypeMap() {
        return amountTypeMap;
    }

    public void setAmountTypeMap(Map<FoodType, Integer> amountPerType) {
        this.amountTypeMap = amountPerType;
    }

    public void addProduct(Food food){
        this.productList.add(food);
    }

    public void removeProduct(Food food){
        this.productList.remove(food);
    }

    private Comparator<Food> compareByPrice = new Comparator<Food>() {
        @Override
        public int compare(Food f1, Food f2) {
            return f1.getPrice().compareTo(f2.getPrice());
        }
    };

    private Comparator<Food> compareByName = new Comparator<Food>() {
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
            System.out.format("%3s %8s %16s %7.2f$ %5d Cal. %8s",
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

    public boolean isOneOfBigger(Double price) {
        for (Food food : this.getProductList()) {
            if (food.getPrice() > price) {
                return true;
            }
        }
        return false;
    }

    public boolean isOneOfLower(Double price) {
        for (Food food : this.getProductList()) {
            if (food.getPrice() < price) {
                return true;
            }
        }
        return false;
    }


    public boolean isOneOfBigger(Integer calories){
        for(Food food: this.getProductList()){
            if(food.getCalories()>calories){
                return true;
            }
        }
        return false;
    }

    public boolean isOneOfLower(Integer calories){
        for(Food food: this.getProductList()){
            if(food.getCalories()<calories){
                return true;
            }
        }
        return false;
    }

    public boolean isOneOf(String size){
        for(Food food: this.getProductList()){
            if(food.getSize().equalsIgnoreCase(size)){
                return true;
            }
        }
        return false;
    }

    public boolean isAllBigger(Double price) {
        for (Food food : this.getProductList()) {
            if (food.getPrice() < price) {
                return false;
            }
        }
        return true;
    }

    public boolean isAllLower(Double price) {
        for (Food food : this.getProductList()) {
            if (food.getPrice() > price) {
                return false;
            }
        }
        return true;
    }

    public boolean isAllBigger(Integer calories){
        for(Food food: this.getProductList()){
            if(food.getCalories() < calories){
                return false;
            }
        }
        return true;
    }

    public boolean isAllLower(Integer calories){
        for(Food food: this.getProductList()){
            if(food.getCalories() > calories){
                return false;
            }
        }
        return true;
    }

    public boolean isAll(String size){
        for(Food food: this.getProductList()){
            if(!food.getSize().equalsIgnoreCase(size)){
                return false;
            }
        }
        return true;
    }

    public boolean isNoneBigger(Double price) {
        for (Food food : this.getProductList()) {
            if (food.getPrice() > price) {
                return false;
            }
        }
        return true;
    }

    public boolean isNoneLower(Double price) {
        for (Food food : this.getProductList()) {
            if (food.getPrice() < price) {
                return false;
            }
        }
        return true;
    }

    public boolean isNoneBigger(Integer calories){
        for(Food food: this.getProductList()){
            if(food.getCalories() > calories){
                return false;
            }
        }
        return true;
    }

    public boolean isNoneLower(Integer calories){
        for(Food food: this.getProductList()){
            if(food.getCalories() < calories){
                return false;
            }
        }
        return true;
    }

    public boolean isNone(String size){
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

    public int getAmountPerType(FoodType foodType){
        int counter = 0;
        for(Food food: this.getProductList()){
            if(food.getType().equals(foodType)){
                counter++;
            }
        }
        return counter;
    }

    public void fillAmountTypeMap(){
        for(int i=0;i<FoodType.values().length;i++){
            this.amountTypeMap.put(FoodType.values()[i], getAmountPerType(FoodType.values()[i]));
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                ", filteredList=" + filteredList +
                ", amountPerType=" + amountTypeMap +
                ", compareByPrice=" + compareByPrice +
                ", compareByName=" + compareByName +
                '}';
    }
}
