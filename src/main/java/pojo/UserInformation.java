package pojo;

public final class UserInformation {
    private String firstName;
    private String lastName;
    private String genderValue;
    private String maritalStatus;
    private String nationValue;
    private String birthdayValue;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setNationValue(String nationValue) {
        this.nationValue = nationValue;
    }

    public void setBirthdayValue(String birthdayValue) {
        this.birthdayValue = birthdayValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getNationValue() {
        return nationValue;
    }

    public String getBirthdayValue() {
        return birthdayValue;
    }
}
