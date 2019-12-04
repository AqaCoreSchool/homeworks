package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;
import ua.biz.test.entity.Vacancy;

import java.util.List;

public class VacanciesListPage extends BasePage {

    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement addVacancyButton;

    @FindBy(xpath = "//table[@id='resultTable']//tbody//tr[@class='odd' or @class='even']")
    List<WebElement> vacanciesDataList;

    public VacanciesListPage() {
        super();
    }

    public CreateVacancyPage addNewVacancy() {
        WaitUtil.waitAndClick(addVacancyButton);
        return new CreateVacancyPage();
    }

    public boolean isVacancyPresent(Vacancy vacancy) {
        return vacanciesDataList.stream().map(WebElement::getText).
                anyMatch(data -> data.contains(vacancy.getName()) &&
                        data.contains(vacancy.getHiringManagerName()));
    }
}
