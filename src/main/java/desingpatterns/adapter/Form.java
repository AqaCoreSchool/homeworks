package desingpatterns.adapter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public interface Form {

    void configure(WebDriverWait wait, List<WebElement> fields);
}
