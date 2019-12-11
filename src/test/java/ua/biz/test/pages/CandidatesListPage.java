package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;
import ua.biz.test.entity.Candidate;


import java.util.List;

public class CandidatesListPage extends BasePage {

    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement addCandidateButton;

    @FindBy(xpath = "//table[@id='resultTable']//tbody//tr[@class='odd' or @class='even']")
   private List<WebElement> candidatesData;

    public boolean isCandidatesPresent(Candidate candidate) {
        return candidatesData.stream().map(WebElement::getText).anyMatch(data->data.contains(candidate.getFullName())&&
                data.contains(candidate.getVacancy().getName()));
    }

    public CreateCandidatePage addNewCandidate(){
        WaitUtil.waitAndClick(addCandidateButton,5);
      return new CreateCandidatePage();
    }
}
