package testpackage.test.sqlTest;

import org.testng.annotations.Test;
import testpackage.dataProvider.VacancySQL;
import testpackage.pages.LoginPage;
import testpackage.pages.VacanciesPage;

import java.util.ArrayList;;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class VacancyInWebTest {

    @Test
    public void testRecruitment() {
        ArrayList<String> map = new ArrayList<>();

        VacancySQL vacancySqlDataProvider = new VacancySQL();
        String vacancyFromSql = vacancySqlDataProvider.getVacanciesByEmployeeNameList("AQA Jun",
                "Pazykov").toString();

        Pattern pattern = Pattern.compile("\\b\\w*([A-z])\\w*\\b");
        Matcher matcher = pattern.matcher(vacancyFromSql);
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i += 1) {
                map.add(matcher.group(i));
            }
        }
        String vacancyTitleFromSql = map.get(4);
        String lastNameFromSql = map.get(9);


        VacanciesPage vacanciesPage = new LoginPage()
                .loginToTheSystem("TestUser03", "Vfylhfujhf!1")
                .moveToVacancies();
        assertThat(vacanciesPage.filterVacancies(vacancyTitleFromSql,lastNameFromSql))
                .as("No vacancy").isTrue();

    }
}
