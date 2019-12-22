package pages;

import data.CandidateData;
import data.VacancyData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Waits;
import utils.WebDriverFactory;

import java.util.List;

public class OrangeRecruitmentPage extends BasePage{
    private String title;
    Waits wait = new Waits(WebDriverFactory.getDriver());

    @FindBy(id = "menu_recruitment_viewJobVacancy")
    private WebElement vacancies;

    @FindBy(id = "btnAdd")
    private WebElement addButton;

    @FindBy(id = "addJobVacancy_jobTitle")
    private WebElement jobTitleList;

    @FindBy(id = "addJobVacancy_name")
    private WebElement vacancyName;

    @FindBy(id = "addJobVacancy_hiringManager")
    private WebElement hiringManager;

    @FindBy(id = "addJobVacancy_noOfPositions")
    private WebElement numberOfPositions;

    @FindBy(id = "addJobVacancy_description")
    private WebElement description;

    @FindBy(id = "addJobVacancy_status")
    private WebElement status;

    @FindBy(id = "addJobVacancy_publishedInFeed")
    private WebElement feedCheckbox;

    @FindBy(id = "btnSave")
    private WebElement saveBtn;

    @FindBy(id = "btnBack")
    private WebElement backBtn;

    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='odd' or @class='even']")
    private List<WebElement> resultList;

    @FindBy(id = "menu_recruitment_viewCandidates")
    private WebElement candidates;

    @FindBy(id = "addCandidate_firstName")
    private WebElement firstName;

    @FindBy(id = "addCandidate_lastName")
    private WebElement lastName;

    @FindBy(id = "addCandidate_email")
    private WebElement email;

    @FindBy(id = "addCandidate_contactNo")
    private WebElement contactNo;

    @FindBy(id = "addCandidate_vacancy")
    private WebElement candidateVacanciesList;

    @FindBy(id = "addCandidate_comment")
    private WebElement candidateComment;

    @FindBy(id = "addCandidate_appliedDate")
    private WebElement appliedDate;

    @FindBy(id = "addCandidate_consentToKeepData")
    private WebElement consentDataCheckbox;

    @FindBy(xpath = "//span[@class = 'validation-error' and @for='addCandidate_appliedDate']" )
    private WebElement futureDateError;

    @FindBy(xpath = "//span[@class = 'validation-error' and @for='addJobVacancy_jobTitle']" )
    private WebElement noTitleError;

    public OrangeRecruitmentPage toVacancies(){
        vacancies.click();
        return this;
    }

    public OrangeRecruitmentPage clickAddBtn(){
        addButton.click();
        return this;
    }

    public OrangeRecruitmentPage selectJobTitle(int index){
        Select jobTitle = new Select(jobTitleList);
        jobTitle.selectByIndex(index);
        title = jobTitle.getFirstSelectedOption().getText();
        return this;
    }

    public OrangeRecruitmentPage setVacancyName(String nameVacancy){
        vacancyName.sendKeys(nameVacancy);
        return this;
    }

    public OrangeRecruitmentPage setHiringManager(String nameManager){
        hiringManager.sendKeys(nameManager);
        return this;
    }

    public OrangeRecruitmentPage setPositionsNumber(String positionsNumber){
        numberOfPositions.sendKeys(positionsNumber);
        return this;
    }

    public OrangeRecruitmentPage setDescription(String text){
        description.sendKeys(text);
        return this;
    }

    public OrangeRecruitmentPage uncheckRssFeed(){
        feedCheckbox.click();
        return this;
    }

    public OrangeRecruitmentPage clickSaveBtn(){
        saveBtn.click();
        wait.waitForInvisibilityByClass("message.success.fadable");
        return this;
    }

    public OrangeRecruitmentPage clickBackBtn(){
        backBtn.click();
        return this;
    }

    public OrangeRecruitmentPage createVacancy(VacancyData vacancy){
        return clickAddBtn()
                .selectJobTitle(vacancy.getJobTitleOption())
                .setVacancyName(vacancy.getVacancyName())
                .setHiringManager(vacancy.getHiringManager())
                .setPositionsNumber(vacancy.getPositions())
                .setDescription(vacancy.getDescription())
                .uncheckRssFeed()
                .clickSaveBtn();
    }

    public OrangeRecruitmentPage createVacancyWithoutTitle(VacancyData vacancy){
        return clickAddBtn()
                .setVacancyName(vacancy.getVacancyName())
                .setHiringManager(vacancy.getHiringManager())
                .setPositionsNumber(vacancy.getPositions())
                .setDescription(vacancy.getDescription())
                .uncheckRssFeed()
                .clickSaveBtn();
    }

    public boolean noTitleErrorDisplayed(){
        return noTitleError.isDisplayed() && noTitleError.getText().equals("Required");
    }

    public boolean findCreatedVacancy(VacancyData vacancy){
        return resultList.stream()
                .anyMatch(o -> o.getText().contains(vacancy.getVacancyName()) &&
                        o.getText().contains(title) &&
                        o.getText().contains(vacancy.getHiringManager()));
    }

    public OrangeRecruitmentPage toCandidates(){
        candidates.click();
        return this;
    }

    public OrangeRecruitmentPage setName(String candidateName){
        firstName.sendKeys(candidateName);
        return this;
    }

    public OrangeRecruitmentPage setLastName(String candidateLastName){
        lastName.sendKeys(candidateLastName);
        return this;
    }

    public OrangeRecruitmentPage setEmail(String candidateEmail){
        email.sendKeys(candidateEmail);
        return this;
    }

    public OrangeRecruitmentPage setContact(String contactNumber){
        contactNo.sendKeys(contactNumber);
        return this;
    }

    public OrangeRecruitmentPage selectVacancyByName(String title){
        Select availableVacancies = new Select(candidateVacanciesList);
        availableVacancies.selectByVisibleText(title);
        return this;
    }

    public OrangeRecruitmentPage addComment(String commentText){
        candidateComment.sendKeys(commentText);
        return this;
    }

    public OrangeRecruitmentPage setApplicationDate(String date){
        appliedDate.clear();
        appliedDate.sendKeys(date + Keys.ENTER);
        return this;
    }

    public OrangeRecruitmentPage allowKeepData(){
        consentDataCheckbox.click();
        return this;
    }

    public OrangeRecruitmentPage applyCandidate(CandidateData candidateApplication){
        return clickAddBtn()
                .setName(candidateApplication.getFirstName())
                .setLastName(candidateApplication.getLastName())
                .setEmail(candidateApplication.getEmail())
                .setContact(candidateApplication.getContactNo())
                .selectVacancyByName(candidateApplication.getVacancyName())
                .addComment(candidateApplication.getComment())
                .allowKeepData()
                .setApplicationDate(candidateApplication.getDate())
                .clickSaveBtn();
    }

    public boolean futureDateErrorDisplayed(){
        return futureDateError.isDisplayed() && futureDateError.getText().equals("Should be less than current date");
    }

    public boolean findCreatedCandidate(CandidateData candidateApplication){
        return resultList.stream()
                .anyMatch(o -> o.getText().contains(candidateApplication.getVacancyName()) &&
                        o.getText().contains(String.format(
                                "%s %s", candidateApplication.getFirstName(), candidateApplication.getLastName())) &&
                        o.getText().contains(candidateApplication.getHiringManager()) &&
                        o.getText().contains(candidateApplication.getDate()));
    }

}
