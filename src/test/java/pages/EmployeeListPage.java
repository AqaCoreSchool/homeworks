package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeListPage extends MainPage{

    @FindBy(tagName = "tr")
    private List<WebElement> employees;

    @Step
    public String findEmployeeInfo(String firstName, String lastName, String id){
        return employees.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(firstName))
                .filter(s -> s.contains(lastName))
                .filter(s -> s.contains(id))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
