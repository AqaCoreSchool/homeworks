package orangetest.data;

import com.github.javafaker.Faker;

public class User {
    private String firstName = "Mariana";
    private String lastName = "Mykytovych";
    private String middleName = "Romanivna";
    private String birthday = "1993-09-07";

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthday() {
        return birthday;
    }
}
