package selenium.model;

import selenium.common.Utils;

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
}
