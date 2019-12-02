package orangetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.List;

public class CandidatesPage {
    private static String vacancy;
    @FindBy(xpath = "//b[contains(text(),'Recruitment')]")
    WebElement menuRecruitment;
    @FindBy(xpath = "//a[@id='menu_recruitment_viewCandidates']")
    WebElement viewCandidates;
    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement btnAdd;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement btnSave;
    @FindBy(xpath = "//input[@id='addCandidate_firstName']")
    WebElement addCandidateFirstName;
    @FindBy(xpath = "//input[@id='addCandidate_lastName']")
    WebElement addCandidateLastName;
    @FindBy(xpath = "//input[@id='addCandidate_middleName']")
    WebElement addCandidateMiddleName;
    @FindBy(xpath = "//input[@id='addCandidate_email']")
    WebElement addCandidateEmail;
    @FindBy(xpath = "//select[@id='addCandidate_vacancy']")
    WebElement addCandidateVacancy;
    @FindBy(xpath = "//table[@id='resultTable']//tbody")
    WebElement resultTable;
    @FindBy(xpath = "//input[@id='addCandidate_consentToKeepData']")
    WebElement consentToKeepData;

    public CandidatesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addCandidate(String firstName, String lastName, String middleName, String candidateEmail) {
        menuRecruitment.click();
        viewCandidates.click();
        btnAdd.click();
        addCandidateFirstName.sendKeys(firstName);
        addCandidateLastName.sendKeys(lastName);
        addCandidateMiddleName.sendKeys(middleName);
        addCandidateEmail.sendKeys(candidateEmail);
        addCandidateVacancy.click();
        List<WebElement> vacancies = addCandidateVacancy.findElements(By.xpath("./*"));
        int size = vacancies.size();
        int random = (int) (Math.random() * size);
        vacancy = vacancies.get(random).getText();
        vacancies.get(random).click();
        consentToKeepData.click();
        btnSave.click();
    }

    public boolean checkAddedCandidate(String firstName, String lastName) {
        viewCandidates.click();
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        LocalDate currentDate = LocalDate.now();
        boolean searchResult = tableRows.stream().map(WebElement::getText).anyMatch(
                o -> o.contains(currentDate.toString()) &&
                        o.contains(firstName) &&
                        o.contains(lastName) &&
                        o.contains(vacancy));
        return searchResult;
    }
}
