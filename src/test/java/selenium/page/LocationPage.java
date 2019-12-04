package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LocationPage extends BasePage {

    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    @FindBy(tagName = "tr")
    private List<WebElement> locationList;


    public CreateLocationPage createNewLocation() {
        getWait().until(ExpectedConditions.visibilityOf(btnAdd));
        btnAdd.click();
        return new CreateLocationPage();
    }

    public boolean checkLocation (String locationName, String locationCity) {
        return locationList.stream()
                .map(WebElement::getText)
                .anyMatch(item -> item.contains(locationName) &&
                        item.contains(locationCity));
    }
}
