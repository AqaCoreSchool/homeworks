package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.Wait;

import java.util.List;

public class CandidatesPage extends BasePage {

    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    @FindBy(tagName = "tr")
    private List<WebElement> usersList;

    public CreateCandidatePage clickNewCandidateButton() {
        Wait.waitForElementToBeClickable(btnAdd);
        btnAdd.click();
        return new CreateCandidatePage();
    }

    public boolean isCandidateWithVacancyPresent(String candidateName, String vacancyName) {
        return usersList.stream()
                .map(WebElement::getText)
                .anyMatch(item -> item.contains(candidateName) &&
                        item.contains(vacancyName));
    }
}
