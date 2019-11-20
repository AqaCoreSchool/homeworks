package com.burgerking;

import com.burgerking.exception.FilteredListIsEmptyException;
import com.burgerking.exception.FoodTypeNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    private String name;
    private List<Food> productList;
    private List<Food> filteredList;
    private Map<FoodType, Integer> amountPerTypeMap;
    private LocalDateTime menuCreationDateTime;

    public Menu(String name) {
        this.name = name;
        this.productList = new ArrayList<>();
        this.filteredList = new ArrayList<>();
        this.amountPerTypeMap = new HashMap<>();
        this.menuCreationDateTime = LocalDateTime.now();
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

    public Map<FoodType, Integer> getAmountPerTypeMap() {
        return amountPerTypeMap;
    }

    public void setAmountPerTypeMap(Map<FoodType, Integer> amountPerType) {
        this.amountPerTypeMap = amountPerType;
    }

    public LocalDateTime getMenuCreationDateTime() {
        return menuCreationDateTime;
    }

    public void setMenuCreationDateTime(LocalDateTime menuCreationDateTime) {
        this.menuCreationDateTime = menuCreationDateTime;
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

    public void showMenu(List<Food> list){
        int printIdCounter = 0;
        System.out.printf("Menu for %s:\n", this.menuCreationDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ROOT));
        for(Food food: list){
            printIdCounter++;
            System.out.format("%3s %8s %18s %7.2f$ %5d Cal. %8s",
                    printIdCounter, food.getTypeName(), food.getName(), food.getPrice(), food.getCalories(), food.getSize());
            System.out.println();
        }
        System.out.println();
    }

    public void filterMenuByFoodType(int filterOption) {
        if(filterOption < 0 || filterOption > FoodType.values().length){
            throw new FoodTypeNotFoundException("There is no such food type in menu!");
        }
        List<Food> filtered = this.productList.stream()
                .filter(food -> food.getType().ordinal()==filterOption).collect(Collectors.toList());
        if(filtered.isEmpty()){
            throw new FilteredListIsEmptyException("No food of this type in menu - nothing to filter!");
        }
        this.setFilteredList(filtered);
    }

    public boolean isAnyFoodPriceBiggerThan(Double price) {
        return this.productList.stream().anyMatch(food -> food.getPrice()>price);
    }

    public boolean isAllFoodCaloriesLowerThen(Integer calories){
        return this.productList.stream().allMatch(food -> food.getCalories()<calories);
    }

    public boolean isNoneFoodSizeEqualsTo(String size){
        return this.productList.stream().noneMatch(food -> food.getSize().equalsIgnoreCase(size));
    }

    public String getLowestPriceByType(){
        List<Food> typesList = new ArrayList<>();
        for(int i=0;i<FoodType.values().length;i++){
            int filterOption = i;
            typesList.add(this.productList.stream().sorted(compareByPrice)
                    .filter(food -> food.getType().ordinal()==filterOption).findFirst().orElse(null));
        }
        return typesList.stream()
                .filter(Objects::nonNull).sorted(compareByName).distinct()
                .map(Food::getNamePricePairFormatted).collect(Collectors.joining(", "));
    }

    public void fillAmountPerTypeMap(){
        for(int i=0;i<FoodType.values().length;i++){
            int foodType = i;
            this.amountPerTypeMap.put(FoodType.values()[foodType], (int) this.productList.stream().
                    filter(food -> food.getType().ordinal()== foodType).count());
        }
    }

    public void showAmountPerTypeMap(){
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.printf("Amount of items per Type at this moment %s:\n", currentDateTime);
        System.out.println(this.amountPerTypeMap.entrySet());
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                ", filteredList=" + filteredList +
                ", amountPerType=" + amountPerTypeMap +
                ", compareByPrice=" + compareByPrice +
                ", compareByName=" + compareByName +
                '}';
    }
}
