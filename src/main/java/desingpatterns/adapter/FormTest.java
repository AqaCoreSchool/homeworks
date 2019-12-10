package desingpatterns.adapter;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormTest {

    private Faker faker = new Faker();
    private FormPage formPage;
    private WebDriverWait wait;
    private String email = faker.bothify("????##@gmail.com");
    private String phone = faker.phoneNumber().phoneNumber();
    private String city = faker.address().city();
    private String country = faker.address().country();
    private String region = faker.address().state();

    @DataProvider(name = "Form data")
    public Object[][] formData() {
        return new Object[][] {
                {
                    FormList.FIRST, FirstForm.builder()
                        .email(email)
                        .phone(phone)
                        .build()
                },
                {
                    FormList.SECOND, SecondForm.builder()
                        .city(city)
                        .country(country)
                        .region(region)
                        .build()
                }
        };
    }

    @Test(dataProvider = "Form data")
    public void testSubmittingForm(FormList formName, Form form) {
        formPage.selectForm(formName).clearInputFields();
        form.configure(wait, formPage.getFields());
        formPage.confirmChanges();

        // Make assertion with successful message
    }

}
