package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CandidatesListPage {


    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement addCandidateButton;

    public CandidatesListPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public CreateCandidatePage addNewCandidate(WebDriver driver){
        addCandidateButton.click();
      return new CreateCandidatePage(driver);
    }

}
