package tests;

import data.LoginInfo;
import data.Sort;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingByNameTest extends  BaseTest{


    @Test
    public void TestSortingByName(){

        MainPage mainPage = loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD)
                .selectSorting(Sort.sortingByNameDescend);

//        assertThat(mainPage.getElements())
    }
}
