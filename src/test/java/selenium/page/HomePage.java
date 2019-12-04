package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import selenium.common.Wait;
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

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminMenu;

    @FindBy(id = "menu_admin_Organization")
    private WebElement organizationMenu;

    @FindBy(id = "menu_admin_viewLocations")
    private WebElement locationsItem;

    public HomePage() {
        super();
        actions = new Actions(Driver.getInstance().getDriver());
    }

    public HomePage moveToTimeItem() {
        Wait.waitForVisible(timeItem);
        actions.moveToElement(timeItem).perform();
        return this;
    }

    public HomePage moveToRecruitmentItem() {
        Wait.waitForElementToBeClickable(recruitmentItem);
        actions.moveToElement(recruitmentItem).perform();
        return this;
    }

    public HomePage moveToPimItem() {
        Wait.waitForVisible(pimButton);
        actions.moveToElement(pimButton).perform();
        return this;
    }

    public HomePage moveToAdminMenu() {
        Wait.waitForVisible(adminMenu);
        adminMenu.click();
        return this;
    }

    public LocationPage moveToOrganizationMenu() {
        actions.moveToElement(organizationMenu).perform();
        Wait.waitForVisible(locationsItem);
        locationsItem.click();
        return new LocationPage();
    }

    public EmployeeListPage clickEmployeeListButton() {
        Wait.waitForElementToBeClickable(employeeListButton);
        employeeListButton.click();
        return new EmployeeListPage();
    }

    public CandidatesPage clickCandidateListButton() {
        Wait.waitForElementToBeClickable(candidatesButton);
        candidatesButton.click();
        return new CandidatesPage();
    }

    public VacanciesPage clickVacanciesButton() {
        Wait.waitForElementToBeClickable(vacanciesButton);
        vacanciesButton.click();
        return new VacanciesPage();
    }

    public HomePage moveMenuAttendanceItem() {
        Wait.waitForVisible(attendanceItem);
        actions.moveToElement(attendanceItem).perform();
        return this;
    }

    public PunchInOutPage clickPunchIn() {
        Wait.waitForElementToBeClickable(punchInOutButton);
        punchInOutButton.click();
        return new PunchInOutPage();
    }

    public MyRecordsPage clickMyRecords() {
        Wait.waitForElementToBeClickable(myRecordsButton);
        myRecordsButton.click();
        return new MyRecordsPage();
    }

    public MyInfoPage clickMyInfo() {
        Wait.waitForElementToBeClickable(myInfoButton);
        myInfoButton.click();
        return new MyInfoPage();
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }
}
