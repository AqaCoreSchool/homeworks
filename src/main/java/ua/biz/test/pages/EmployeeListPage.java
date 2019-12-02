package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage {
    public EmployeeListPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
