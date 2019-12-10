package desingpatterns.adapter;

import lombok.Builder;
import lombok.Value;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Value
@Builder
public class SecondForm implements Form {

    private String city;
    private String country;
    private String region;

    @Override
    public void configure(WebDriverWait wait, List<WebElement> fields) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading")));
        fields.get(3).sendKeys(this.getCity());
        fields.get(4).sendKeys(this.getCountry());
        fields.get(5).sendKeys(this.getRegion());
    }
}
