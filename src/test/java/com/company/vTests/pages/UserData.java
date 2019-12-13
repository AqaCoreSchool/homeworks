package com.company.vTests.pages;

import com.company.vTests.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class UserData extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postCodeInput;

    @FindBy(xpath = "//input[@class='btn_primary cart_button']")
    private WebElement continueBtn;

    public UserData fillUserInfo(String firstName, String lastName, String postCode){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);
        return this;
    }

    public BasketPage moveToBasket(){
        continueBtn.click();
        return new BasketPage();
    }

}
