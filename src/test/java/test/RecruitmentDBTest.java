package test;

import data.EmployeeSQLData;
import data.JobVacancySQLData;
import data.VacancyData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrangeRecruitmentPage;
import utils.EmployeeSQLDataProvider;
import utils.VacancySQLDataProvider;

import java.util.List;

public class RecruitmentDBTest extends BaseTest{
    VacancyData vacancy = new VacancyData("DBTEST", "Nazariy Kushnir");

    @Test
    public void createVacancyAndCheckInDB(){
        OrangeRecruitmentPage recruitmentPage = openLoginPage()
                .loginCorrect(USERNAME, PASSWORD)
                .toRecruitmentModulePage()
                .toVacancies()
                .createVacancy(vacancy);
        recruitmentPage.clickBackBtn();
        VacancySQLDataProvider.getVacancyPool();
        EmployeeSQLDataProvider.getEmployeePool();
        EmployeeSQLData emp = VacancySQLDataProvider.getEmployeesByJobVacancyName(vacancy.getVacancyName());
        List<JobVacancySQLData> vacanciesByEmployee = EmployeeSQLDataProvider.getVacanciesByEmployeeName(emp.getEmp_firstname(), emp.getEmp_lastname());
        boolean found = vacanciesByEmployee.stream().anyMatch(vacancySQLData -> vacancySQLData.getName().equals(vacancy.getVacancyName()));
        Assert.assertTrue(found, "Created vacancy by this hiring manager not found in DB");
    }
}
