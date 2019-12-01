package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrangeRecruitmentPage {
    private final WebDriver driver;
    private WebElement createdVacancy;
    private WebElement createdCandidate;
    private String title;
    private String recordVacancyName;

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

    public OrangeRecruitmentPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getCreatedVacancy() {
        return createdVacancy;
    }

    public WebElement getCreatedCandidate() {
        return createdCandidate;
    }

    public OrangeRecruitmentPage toVacancies(){
        vacancies.click();
        return this;
    }

    public OrangeRecruitmentPage clickAddBtn(){
        addButton.click();
        return this;
    }

    public OrangeRecruitmentPage selectJobTitle(){
        Select jobTitle = new Select(jobTitleList);
        jobTitle.selectByIndex(1);
        title = jobTitle.getFirstSelectedOption().getText();
        return this;
    }

    public OrangeRecruitmentPage setVacancyName(String nameVacancy){
        vacancyName.sendKeys(nameVacancy);
        recordVacancyName = nameVacancy;
        return this;
    }

    public OrangeRecruitmentPage setHiringManager(String nameManager){
        hiringManager.sendKeys(nameManager);
        return this;
    }

    public OrangeRecruitmentPage setPositionsNumber(){
        numberOfPositions.sendKeys("1");
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
        WebDriverWait saveWait = new WebDriverWait(driver, 10);
        saveWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("message.success.fadable")));
        return this;
    }

    public OrangeRecruitmentPage clickBackBtn(){
        backBtn.click();
        return this;
    }

    public OrangeRecruitmentPage createVacancy(String nameVacancy, String nameManager, String text){
        return clickAddBtn()
                .selectJobTitle()
                .setVacancyName(nameVacancy)
                .setHiringManager(nameManager)
                .setPositionsNumber()
                .setDescription(text)
                .uncheckRssFeed()
                .clickSaveBtn();
    }

    public OrangeRecruitmentPage findCreatedVacancy(String nameVacancy, String hiringManager){
        createdVacancy = resultList.stream()
                .filter(o -> o.findElements(By.xpath("./td")).get(1).getText().contains(nameVacancy) &&
                        o.findElements(By.xpath("./td")).get(2).getText().contains(title) &&
                        o.findElements(By.xpath("./td")).get(3).getText().contains(hiringManager))
                .findFirst().orElse(null);
        return this;
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

    public OrangeRecruitmentPage applyCandidate(String candidateName, String candidateLastName, String candidateMail,
                                                String contactNumber, String title, String commentText, String date){
        return clickAddBtn()
                .setName(candidateName)
                .setLastName(candidateLastName)
                .setEmail(candidateMail)
                .setContact(contactNumber)
                .selectVacancyByName(title)
                .addComment(commentText)
                .allowKeepData()
                .setApplicationDate(date)
                .clickSaveBtn();
    }

    public OrangeRecruitmentPage findCreatedCandidate(String candidateName, String candidateLastName,
                                                      String hiringManager, String recordVacancyName, String date){
        String candidate = String.format("%s %s", candidateName, candidateLastName);
        createdCandidate = resultList.stream()
                .filter(o -> o.findElements(By.xpath("./td")).get(1).getText().contains(recordVacancyName) &&
                        o.findElements(By.xpath("./td")).get(2).getText().contains(candidate) &&
                        o.findElements(By.xpath("./td")).get(3).getText().contains(hiringManager) &&
                        o.findElements(By.xpath("./td")).get(4).getText().contains(date))
                .findFirst().orElse(null);
        return this;
    }

}
