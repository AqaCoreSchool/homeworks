package Data;

import com.github.javafaker.Faker;

public class CheckoutInformation {
    Faker faker = new Faker();
    private String firstName = faker.firstName();
    private String lastName = faker.lastName();
    private String postalCode = faker.zipCode();

    public CheckoutInformation() {

    }

    public CheckoutInformation(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
