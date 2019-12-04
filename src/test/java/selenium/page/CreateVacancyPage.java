package selenium.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.common.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class CreateVacancyPage extends BasePage {

    @FindBy(id = "frmAddJobVacancy")
    private WebElement vacancyForm;

    @FindBy(id = "addJobVacancy_jobTitle")
    private WebElement jobTitle;

    @FindBy(id = "addJobVacancy_name")
    private WebElement vacancyName;

    @FindBy(id = "addJobVacancy_hiringManager")
    private WebElement hiringManager;

    @FindBy(id = "addJobVacancy_noOfPositions")
    private WebElement noOfPositions;

    @FindBy(id = "addJobVacancy_description")
    private WebElement description;

    @FindBy(id = "addJobVacancy_status")
    private WebElement status;

    @FindBy(id = "addJobVacancy_publishedInFeed")
    private WebElement publishedInFeed;

    @FindBy(id = "btnSave")
    private WebElement btnSave;

    @FindBy(xpath = "//div[@class='message success fadable']")
    private WebElement successMsg;

    @FindBy(className = "validation-error")
    private List<WebElement> requiredFields;

    public CreateVacancyPage fillJobTitle(String title) {
        getWait().until(ExpectedConditions.visibilityOf(jobTitle));
        jobTitle.sendKeys(title);
        return this;
    }

    public CreateVacancyPage fillVacancyName(String name) {
        vacancyName.sendKeys(name);
        return this;
    }

    public CreateVacancyPage fillHiringManager(String name) {
        hiringManager.sendKeys(name, Keys.ENTER);
        return this;
    }

    public CreateVacancyPage fillPositionsNo(String numberOfPositions) {
        noOfPositions.sendKeys(numberOfPositions);
        return this;
    }

    public CreateVacancyPage fillDescription(String description) {
        this.description.sendKeys(description);
        return this;
    }

    public CreateVacancyPage setJobStatus() {
        if (!status.isSelected()) {
            status.click();
        }
        return this;
    }

    public CreateVacancyPage setPublishedInFeedStatus() {
        if (!publishedInFeed.isSelected()) {
            publishedInFeed.click();
        }
        return this;
    }

    public CreateVacancyPage saveVacancy() {
        getWait().until(ExpectedConditions.elementToBeClickable(btnSave));
        btnSave.click();
        return this;
    }

    public String getSuccessMessage() {
        getWait().until(ExpectedConditions.visibilityOf(successMsg));
        return successMsg.getText();
    }

    public boolean checkValidation() {
        return requiredFields.isEmpty();
    }

    public String getValidationMessage() {
        return requiredFields.stream()
                .map(WebElement::getText)
                .filter(message -> message.contains(Utils.getProperty("required")) ||
                        message.contains(Utils.getProperty("invalid")) ||
                        message.contains(Utils.getProperty("expectedFormat")))
                .collect(Collectors.joining("\n"));
    }
}
