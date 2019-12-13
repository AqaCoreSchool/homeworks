package com.company.vTests.pages;

import com.company.vTests.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//div[@class='cart_list']")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//input[@class='btn_primary cart_button']")
    private WebElement continueBtn;


    public boolean verifyProductBasket(String productName){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean products = listOfProducts.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(productName));
        return products;
    }

    public UserData clickCheckout(){
        checkoutBtn.click();
        return new UserData();
    }

//    public List<WebElement> addProducts(String productName){
//        products = products.stream().filter(element -> element.getText().contains(productName))
//                .collect(Collectors.toList());
//        System.out.println(products);
//        return products;
//    }

}
