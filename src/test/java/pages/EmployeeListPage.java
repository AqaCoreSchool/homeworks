package pages;

import data.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeListPage extends MainPage{

    @FindBy(tagName = "tr")
    private List<WebElement> employees;

    @Step
    public String findEmployeeInfo(User user){
        return employees.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(user.getFirstName()))
                .filter(s -> s.contains(user.getLastName()))
                .filter(s -> s.contains(user.getId()))
                .findAny()
                .orElse("");
    }
}
