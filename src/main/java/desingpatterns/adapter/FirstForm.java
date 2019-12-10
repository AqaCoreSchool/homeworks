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
public class FirstForm implements Form {

    private String email;
    private String phone;

    @Override
    public void configure(WebDriverWait wait, List<WebElement> fields) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading")));
        fields.get(1).sendKeys(this.getEmail());
        fields.get(2).sendKeys(this.getPhone());
    }
}
