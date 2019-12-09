package test;

import data.VacancyData;
import pages.OrangeRecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateVacancyTest extends BaseTest{
    VacancyData vacancy = new VacancyData("Test vacancy", "Nazariy Kushnir");


    @Test(priority = 1)
    public void createVacancyTest(){
        OrangeRecruitmentPage recruitmentPage = openLoginPage()
                .loginCorrect(USERNAME, PASSWORD)
                .toRecruitmentModulePage()
                .toVacancies()
                .createVacancy(vacancy);
        recruitmentPage.clickBackBtn();
        Assert.assertTrue(recruitmentPage.findCreatedVacancy(vacancy), "Created vacancy not found!");
    }

    @Test(priority = 2)
    public void createIncorrectVacancyTest(){
        OrangeRecruitmentPage recruitmentPage = openLoginPage()
                .loginCorrect(USERNAME, PASSWORD)
                .toRecruitmentModulePage()
                .toVacancies()
                .createVacancyWithoutTitle(vacancy);
        Assert.assertTrue( recruitmentPage.noTitleErrorDisplayed(), "Error notification not displayed");
    }
}
