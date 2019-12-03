package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CandidatesPage extends BasePage{
    private boolean isCreated = false;

    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    @FindBy(tagName = "tr")
    private List<WebElement> usersList;

    public CreateCandidatePage clickNewCandidateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
        return new CreateCandidatePage();
    }

    public CandidatesPage checkCandidate (String candidateName, String vacancyName) {
        isCreated = usersList.stream()
                .map(WebElement::getText)
                .anyMatch(item -> item.contains(candidateName) &&
                        item.contains(vacancyName));
        return this;
    }

    public boolean isCreated() {
        return isCreated;
    }

}
