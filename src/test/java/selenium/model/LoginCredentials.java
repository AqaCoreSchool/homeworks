package selenium.model;

import selenium.common.Utils;

public class LoginCredentials {
    private String userLoginName;
    private String userPassword;

    public LoginCredentials(String userLoginName, String userPassword) {
        this.userLoginName = userLoginName;
        this.userPassword = userPassword;
    }

    public LoginCredentials() {
        this.userLoginName = Utils.getProperty("userLoginName");
        this.userPassword = Utils.getProperty("userPassword");
    }

    public String getUserLoginName() {
        return userLoginName;
    }


    public String getUserPassword() {
        return userPassword;
    }
}
