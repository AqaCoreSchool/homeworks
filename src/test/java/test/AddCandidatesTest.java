package test;

import org.testng.annotations.Test;
import testpackage.pages.CandidatesPage;
import testpackage.pages.LoginPage;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class AddCandidatesTest {

    private String login = "TestUser03";
    private String password = "Vfylhfujhf!1";
    private String firstName = "Danylo";
    private String middleName = "Alexandrovich";
    private String lastName = "Pazykov";
    private String email = "pazikovd@gmail.com";
    private String date = "2019-12-01";
    private String phoneNumber = "+380506442833";
    private String vacancy = "AQA Junior";
    private String resume = "C:"+File.separator+"Users"+File.separator+"Daniel"
                             +File.separator+"Desktop"+File.separator+"Pazykov Danylo.pdf";

    @Test
    public void candidatesAddTest(){
    LoginPage loginPage = new LoginPage();
        loginPage
                .loginToTheSystem(login,password)
                .moveToRecruitment()
                .moveToCandidates()
                .clickAddCandidate()
                .inputFullName(firstName,middleName,lastName)
                .inputEmail(email)
                .selectAQAJunior()
                .inputResume(resume)
                .inputPhoneNumber(phoneNumber)
                .clickConsentAndSave()
                .moveToCandidates();
        assertThat(new CandidatesPage().filterCandidates(firstName,middleName,lastName,vacancy,date)).isTrue();
    }
}
