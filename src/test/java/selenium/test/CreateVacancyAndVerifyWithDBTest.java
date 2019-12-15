package selenium.test;

import database.dataprovider.EmployeeSQLDataProvider;
import database.dataprovider.VacancySQLDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.model.Candidate;
import selenium.model.Vacancy;
import selenium.page.VacanciesPage;

import java.util.List;

public class CreateVacancyAndVerifyWithDBTest extends BaseTest {

    @Test
    public void createVacancyAndVerifyWithDBTest() {
        Vacancy vacancy = new Vacancy();
        VacanciesPage page = getLoginPage()
                .fillUsername(getCredentials().getUserLoginName())
                .fillPassword(getCredentials().getUserPassword())
                .clickLoginButton()
                .moveToRecruitmentItem()
                .clickVacanciesButton()
                .clickNewVacancyButton()
                .fillJobTitle(vacancy.getJobTitle())
                .fillVacancyName(vacancy.getVacancyName())
                .fillHiringManager(vacancy.getHiringManager())
                .fillPositionsNo(vacancy.getNoOfPositions())
                .fillDescription(vacancy.getDescription())
                .setJobStatus()
                .setPublishedInFeedStatus()
                .saveVacancy()
                .goBack();

        String dbVacancyName = "", dbEmployeeLastName = "";
        VacancySQLDataProvider vacancyProvider = new VacancySQLDataProvider();
        vacancyProvider.performQuery();
        List<Candidate> resultList = vacancyProvider.getEmployeesByJobVacancyName(vacancy.getVacancyName());
        for (Candidate candidate : resultList) {
            dbEmployeeLastName = candidate.getCandidateLastName();
        }

        EmployeeSQLDataProvider employeeProvider = new EmployeeSQLDataProvider();
        List<Vacancy> result = employeeProvider.getVacanciesByEmployeeName(getUser().getUserFirstName(),
                getUser().getUserLastName());
        for (Vacancy candidate : result) {
            dbVacancyName = candidate.getVacancyName();
        }

        Assert.assertTrue(page.isVacancyCreated(dbVacancyName, dbEmployeeLastName),
                "Vacancy was not created");

    }
}