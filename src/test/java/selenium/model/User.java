package selenium.model;

import selenium.common.Utils;

public class User {
    private String userFirstName;
    private String userLastName;
    private String userOtherId;
    private String userId;
    private String userLicenceNo;
    private String userLicenceExpDate;
    private String userBirthDate;
    private String userNation;
    private String userMarital;
    private String userGender;

    private String userLoginName;
    private String userPassword;

    public User() {
        this.userFirstName = Utils.getProperty("userFirstName");
        this.userLastName = Utils.getProperty("userLastName");
        this.userOtherId = Utils.getProperty("userOtherId");
        this.userId = Utils.getProperty("userId");
        this.userLicenceNo = Utils.getProperty("userLicenceNo");
        this.userLicenceExpDate = Utils.getCurrentDate().plusYears(20).toString();
        this.userBirthDate = Utils.getProperty("userBirthDate");
        this.userNation = Utils.getProperty("userNation");
        this.userMarital = Utils.getProperty("userMarital");
        this.userGender = Utils.getProperty("userGender");
        this.userLoginName = Utils.getProperty("userLoginName");
        this.userPassword = Utils.getProperty("userPassword");
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserOtherId() {
        return userOtherId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserLicenceNo() {
        return userLicenceNo;
    }

    public String getUserLicenceExpDate() {
        return userLicenceExpDate;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public String getUserNation() {
        return userNation;
    }

    public String getUserMarital() {
        return userMarital;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
