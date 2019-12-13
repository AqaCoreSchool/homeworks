package ua.biz.test.entity;

import org.openqa.selenium.WebElement;

import java.util.PrimitiveIterator;

public class Product {
    private String name;
    private String price;
    private WebElement element;

    public WebElement getElement() {
        return element;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
