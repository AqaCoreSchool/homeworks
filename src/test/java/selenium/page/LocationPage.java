package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.Wait;

import java.util.List;

public class LocationPage extends BasePage {

    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    @FindBy(tagName = "tr")
    private List<WebElement> locationList;


    public CreateLocationPage createNewLocation() {
        Wait.waitForVisible(btnAdd);
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
