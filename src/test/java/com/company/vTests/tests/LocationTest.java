package com.company.vTests.tests;

import com.company.vTests.base.BaseTest;
import com.company.vTests.pages.LocationPage;
import com.company.vTests.pages.LoginPage;
import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest extends BaseTest {
    LoginPage loginPage;
    Faker faker = new Faker();
    String name = faker.name().fullName();
    String country = "Ukraine";


    @Test
    @Description("Test Negative Candidates")
    public void testNegativeCandidates() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser07", "Vfylhfujhf!1")
                .moveToAdmin()
                .moveToOrganization()
                .moveToLocation()
                .clickAddLocation()
                .inputLocationData(name)
                .clickSaveLocation();

        LocationPage locationPage = new LocationPage();
        assertThat(locationPage.verifyLocation(name, country)).as("Hasn't note about this location").isTrue();
    }
}
