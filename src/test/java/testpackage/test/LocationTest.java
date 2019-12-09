package testpackage.test;

import org.testng.annotations.Test;
import testpackage.base.BaseTest;
import testpackage.entity.Location;
import testpackage.factory.LocationFactory;
import testpackage.pages.LocationPage;
import testpackage.pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest extends BaseTest {
    private String login = "TestUser03";
    private String password = "Vfylhfujhf!1";

    @Test
    public void locationAddTest(){
        Location location = new LocationFactory().defaultLocation();
        LoginPage loginPage = new LoginPage();
        loginPage
                .loginToTheSystem(login,password)
                .moveToLocation()
                .createLocation(location)
                .moveToLocation();
        assertThat(new LocationPage().filterTable(location)).isTrue();
    }
}
