package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.common.Utils;
import selenium.data.UserData;
import selenium.data.VacancyData;
import selenium.page.CreateCandidatePage;

public class CreateCandidatePageTest extends BaseTest {
    @Test
    public void createCandidateTest() {
        CreateCandidatePage page = getLoginPage()
                .fillUsername(UserData.USER_LOGIN_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickCandidateListButton()
                .clickNewCandidateButton()
                .fillFirstName(UserData.USER_NAME)
                .fillLastName(UserData.USER_LASTNAME)
                .fillEmail(UserData.USER_EMAIL)
                .fillContactNo(UserData.USER_CONTACT_NO)
                .selectVacancy(VacancyData.VACANCY_NAME)
                .fillDate(Utils.getCurrentDate().toString())
                .btnSaveClick();

        String successMessage = page.getSuccessMessage();
        Assert.assertEquals(successMessage, "Successfully Saved\nClose");
    }
}
