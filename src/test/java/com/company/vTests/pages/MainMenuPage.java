package com.company.vTests.pages;

import com.company.vTests.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainMenuPage extends BasePage {

    @FindBy(className = "inventory_list")
    private WebElement addToCardBtn1;

    @FindBy(xpath = "//body[@class='main-body']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]")
    private WebElement addToCardBtn2;


    @FindBy(className = "inventory_list")
    private List<WebElement> products;

    @FindBy(xpath = "//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x')]")
    private WebElement shoppingBasket;


    public MainMenuPage addTwoProducts(){
        addToCardBtn1.click();
        addToCardBtn2.click();
        return this;
    }

//    public List<WebElement> addProducts(String productName){
//        products = products.stream().filter(element -> element.getText().contains(productName))
//                .collect(Collectors.toList());
//        System.out.println(products);
//        return products;
//    }

    public BasketPage moveToShoppingBasket(){
        shoppingBasket.click();
        return new BasketPage();
    }

}

