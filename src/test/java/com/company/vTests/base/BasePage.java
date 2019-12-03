package com.company.vTests.base;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Application{
    public final WebDriverWait wait;

    public BasePage(){
        PageFactory.initElements(Application.getDriver(), this);
        wait = new WebDriverWait(Application.getDriver(), 4);
    }


}
