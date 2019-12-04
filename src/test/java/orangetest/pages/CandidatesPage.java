package orangetest.pages;

import orangetest.data.Candidate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;

public class CandidatesPage extends BasePage {
    public static String vacancy;
    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement btnAdd;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement btnSave;
    @FindBy(id = "btnSrch")
    WebElement btnSrch;
    @FindBy(xpath = "//input[@id='addCandidate_firstName']")
    WebElement addCandidateFirstName;
    @FindBy(id = "btnBack")
    WebElement btnBack;
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
    @FindBy(css = "div.box:nth-child(2) div.inner ol:nth-child(1) li.line.nameContainer:nth-child(1) ol.fieldsInLine li:nth-child(1) > span.validation-error")
    WebElement errorFirstName;
    @FindBy(css = "div.box:nth-child(2) div.inner ol:nth-child(1) li.line.nameContainer:nth-child(1) ol.fieldsInLine li:nth-child(3) > span.validation-error")
    WebElement errorLastName;
    @FindBy(css = "div.box:nth-child(2) div.inner form:nth-child(1) fieldset:nth-child(2) ol:nth-child(1) li:nth-child(2) > span.validation-error:nth-child(3)")
    WebElement errorEmail;
    @FindBy(id = "candidateSearch_fromDate")
    WebElement searchFromDate;
    @FindBy(id = "candidateSearch_candidateName")
    WebElement searchName;

    Candidate candidate = new Candidate();

    public CandidatesPage() {
        super();
    }

    public CandidatesPage addCandidate() {
        menuRecruitment.click();
        viewCandidates.click();
        btnAdd.click();
        addCandidateFirstName.sendKeys(candidate.getCandidateFirstName());
        addCandidateLastName.sendKeys(candidate.getCandidateLastName());
        addCandidateMiddleName.sendKeys(candidate.getCandidateMiddleName());
        addCandidateEmail.sendKeys(candidate.getCandidateEmail());
        addCandidateVacancy.click();
        List<WebElement> vacancies = addCandidateVacancy.findElements(By.xpath("./*"));
        int size = vacancies.size();
        int random = (int) (Math.random() * size);
        vacancy = vacancies.get(random).getText();
        vacancies.get(random).click();
        consentToKeepData.click();
        btnSave.click();
        return this;
    }

    public boolean addEmptyCandidate() {
        menuRecruitment.click();
        viewCandidates.click();
        btnAdd.click();
        btnSave.click();
        try {
            System.out.println("First Name. Error message: " + errorFirstName.getText());
            System.out.println("Last Name. Error message: " + errorLastName.getText());
            System.out.println("Email Name. Error message: " + errorEmail.getText());
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Error messages is not displaying correctly");
            return false;
        }
    }

    public boolean checkAddedCandidate() {
        viewCandidates.click();
        LocalDate currentDate = LocalDate.now();
        searchFromDate.click();
        searchFromDate.clear();
        searchFromDate.sendKeys(currentDate.toString());
        String fullName = new StringBuilder(candidate.getCandidateFirstName()).append(" ")
                .append(candidate.getCandidateMiddleName()).append(" ")
                .append(candidate.getCandidateLastName()).toString();
        searchName.sendKeys(fullName, Keys.ENTER);
        btnSrch.click();
        System.out.println("Vacancy: " + vacancy);
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        boolean searchResult = tableRows.stream().map(WebElement::getText).anyMatch(
                o -> o.contains(currentDate.toString()) &&
                        o.contains(vacancy) &&
                        o.contains(candidate.getCandidateLastName()) &&
                        o.contains(candidate.getCandidateFirstName()));
        return searchResult;
    }
}
