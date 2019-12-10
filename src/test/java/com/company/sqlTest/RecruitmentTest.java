package com.company.sqlTest;

import com.company.sqlTest.dataProvider.VacancySqlDataProvider;
import com.company.sqlTest.pages.BaseTest;
import com.company.sqlTest.pages.LoginPage;
import com.company.sqlTest.pages.VacancyPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class RecruitmentTest extends BaseTest {
    LoginPage loginPage;


    @Test
    public void testRecruitment() {
        ArrayList<String> map = new ArrayList<>();

        VacancySqlDataProvider vacancySqlDataProvider = new VacancySqlDataProvider();
        String vacancyFromSql = vacancySqlDataProvider.getVacanciesByEmployeeName("AQA Man", "Bilynska").toString();

        Pattern pattern = Pattern.compile("\\b\\w*([A-z])\\w*\\b");
        Matcher matcher = pattern.matcher(vacancyFromSql);
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i += 1) {
                map.add(matcher.group(i));
            }
        }
        String vacancyTitleFromSql = map.get(3);
        String lastNameFromSql = map.get(9);

        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser07", "Vfylhfujhf!1")
                .moveToRecruitment()
                .moveToVacancy()
                .chooseJobTitleOfVacancy()
                .clickSearchBtn();

        VacancyPage vacancyPage = new VacancyPage();
        assertThat(vacancyPage.verifyVacancy(vacancyTitleFromSql, lastNameFromSql))
                .as("This vacancy hasn't record with this name")
                .isTrue();
    }
}