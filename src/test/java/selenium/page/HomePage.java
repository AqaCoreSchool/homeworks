package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.driver.Driver;

public class HomePage extends BasePage {
    private Actions actions;

    @FindBy(id = "menu_time_viewTimeModule")
    private WebElement timeItem;

    @FindBy(id = "menu_attendance_Attendance")
    private WebElement attendanceItem;

    @FindBy(id = "menu_attendance_punchIn")
    private WebElement punchInOutButton;

    @FindBy(id = "menu_attendance_viewMyAttendanceRecord")
    private WebElement myRecordsButton;

    @FindBy(id = "menu_pim_viewMyDetails")
    private WebElement myInfoButton;

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement pimButton;

    @FindBy(id = "menu_pim_viewEmployeeList")
    private WebElement employeeListButton;

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    private WebElement recruitmentItem;

    @FindBy(id = "menu_recruitment_viewCandidates")
    private WebElement candidatesButton;

    @FindBy(id = "menu_recruitment_viewJobVacancy")
    private WebElement vacanciesButton;

    @FindBy(id = "welcome")
    private WebElement welcomeText;

    public HomePage() {
        super();
        actions = new Actions(Driver.getInstance().getDriver());
    }

    public HomePage moveToTimeItem() {
        wait.until(ExpectedConditions.visibilityOf(timeItem));
        actions.moveToElement(timeItem).perform();
        return this;
    }

    public HomePage moveToRecruitmentItem() {
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentItem));
        actions.moveToElement(recruitmentItem).perform();
        return this;
    }

    public HomePage moveToPimItem() {
        wait.until(ExpectedConditions.visibilityOf(pimButton));
        actions.moveToElement(pimButton).perform();
        return this;
    }

    public EmployeeListPage clickEmployeeListButton() {
        wait.until(ExpectedConditions.elementToBeClickable(employeeListButton));
        employeeListButton.click();
        return new EmployeeListPage();
    }

    public CandidatesPage clickCandidateListButton() {
        wait.until(ExpectedConditions.elementToBeClickable(candidatesButton));
        candidatesButton.click();
        return new CandidatesPage();
    }

    public VacanciesPage clickVacanciesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(candidatesButton));
        vacanciesButton.click();
        return new VacanciesPage();
    }

    public HomePage moveMenuAttendanceItem() {
        wait.until(ExpectedConditions.visibilityOf(attendanceItem));
        actions.moveToElement(attendanceItem).perform();
        return this;
    }

    public PunchInOutPage clickPunchIn() {
        wait.until(ExpectedConditions.elementToBeClickable(punchInOutButton));
        punchInOutButton.click();
        return new PunchInOutPage();
    }

    public MyRecordsPage clickMyRecords() {
        wait.until(ExpectedConditions.elementToBeClickable(myRecordsButton));
        myRecordsButton.click();
        return new MyRecordsPage();
    }

    public MyInfoPage clickMyInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(myInfoButton));
        myInfoButton.click();
        return new MyInfoPage();
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }
}
