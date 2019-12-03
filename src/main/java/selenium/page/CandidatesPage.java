package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CandidatesPage extends BasePage{
    private boolean isCreated = false;

    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='odd' or @class='even']")
    private List<WebElement> usersList;

    public CreateCandidatePage clickNewCandidateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
        return new CreateCandidatePage();
    }

    public CandidatesPage checkCandidate (String candidateName, String vacancyName) {
        isCreated = usersList.stream()
                .anyMatch(item -> item.findElements(By.xpath("./td")).get(1).getText().contains(vacancyName) &&
                        item.findElements(By.xpath("./td")).get(2).getText().contains(candidateName));
        return this;
    }

    public boolean isCreated() {
        return isCreated;
    }

}
