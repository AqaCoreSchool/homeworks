package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.driver.Driver;

import java.util.List;

public class VacanciesPage {
    private WebDriverWait wait;
    private boolean isCreated = false;
    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='odd' or @class='even']")
    private List<WebElement> resultList;

    public VacanciesPage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
    }

    public CreateVacancyPage clickNewVacancyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
        return new CreateVacancyPage();
    }

    public VacanciesPage checkVacancy (String vacancyName, String managerName) {
         isCreated = resultList.stream()
                .anyMatch(item -> item.findElements(By.xpath("./td")).get(1).getText().contains(vacancyName) &&
                        item.findElements(By.xpath("./td")).get(3).getText().contains(managerName));
        return this;
    }

    public boolean isCreated() {
        return isCreated;
    }
}
