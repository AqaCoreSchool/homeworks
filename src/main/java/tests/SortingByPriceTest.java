package tests;

import data.LoginInfo;
import data.Sort;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingByPriceTest extends  BaseTest{

    @Test
    public void TestSortingByPrice(){

        MainPage mainPage = loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD)
                .selectSorting(Sort.sortingByPriceDescend);

//        assertThat(mainPage.getElements())
    }
}
