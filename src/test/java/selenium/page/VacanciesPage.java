package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.Wait;

import java.util.List;

public class VacanciesPage extends BasePage {
    private boolean isCreated = false;

    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    @FindBy(tagName = "tr")
    private List<WebElement> resultList;

    public CreateVacancyPage clickNewVacancyButton() {
        Wait.waitForElementToBeClickable(btnAdd);
        btnAdd.click();
        return new CreateVacancyPage();
    }

    public boolean isVacancyCreated(String vacancyName, String managerName) {
        return isCreated = resultList.stream()
                .map(WebElement::getText)
                .anyMatch(item -> item.contains(vacancyName) &&
                        item.contains(managerName));
    }
}