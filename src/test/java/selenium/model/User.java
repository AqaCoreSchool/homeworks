package selenium.model;

import selenium.common.Utils;

import java.util.Objects;

public class User {
    private String userFirstName;
    private String userLastName;
    private String userId;
    private String userBirthDate;
    private String userNation;


    public User() {
        this.userFirstName = Utils.getProperty("userFirstName");
        this.userLastName = Utils.getProperty("userLastName");
        this.userId = Utils.getProperty("userId");
        this.userBirthDate = Utils.getProperty("userBirthDate");
        this.userNation = Utils.getProperty("userNation");
    }

    public User(String userFirstName, String userLastName, String userId, String userBirthDate, String userNation) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userId = userId;
        this.userBirthDate = userBirthDate;
        this.userNation = userNation;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public String getUserNation() {
        return userNation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userFirstName, user.userFirstName) &&
                Objects.equals(userLastName, user.userLastName) &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(userBirthDate, user.userBirthDate) &&
                Objects.equals(userNation, user.userNation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userFirstName, userLastName, userId, userBirthDate, userNation);
    }
}
